[![Published on Vaadin  Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/shiro-vaadin-integration)
[![Stars on vaadin.com/directory](https://img.shields.io/vaadin-directory/star/shiro-vaadin-integration.svg)](https://vaadin.com/directory/component/shiro-vaadin-integration)

# shiro-vaadin-integration
This library allows you to use Vaadin 10's Router with Apache Shiro.

Instructions
------------
Implement the *Vaadin views*. For example:

```Java
@Route
public class LoginView extends VerticalLayout {}

@Route
public class View1View extends VerticalLayout {}

@Route
public class View2View extends VerticalLayout {}
```

Add a `shiro.ini` file in the `resources` directory and set your security configuration. Configure und ese the `VaadinNavigationRolesAuthorizationFilter`. For example:

```
[main]
authc.loginUrl = /login
vaadin = org.vaadin.shiro.VaadinNavigationRolesAuthorizationFilter
vaadin.loginUrl = /login

[users]
admin = admin, admin
user = user, user

[roles]
admin = *
user = action1:*

[urls]
/ = anon, vaadin
/login = anon, vaadin
/view1 = authc, vaadin[admin]
/view2 = authc, vaadin[user]
```

In order for this to work you have to configure the following filters:

```Java
@WebListener
public class ShiroListener extends EnvironmentLoaderListener { }

@WebFilter(urlPatterns = "/*")
public class ShiroFilter extends VaadinShiroFilter { }
```
