package org.vaadin.shiro.demo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@Route
public class LoginView extends VerticalLayout {

    public LoginView() {
        TextField username = new TextField("Username");
        username.setValue("admin");
        PasswordField password = new PasswordField("Password");
        password.setValue("admin");
        Button signIn = new Button("Sign in", e -> signIn(username.getValue(), password.getValue()));
        signIn.focus();

        add(username, password, signIn);
    }

    private void signIn(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            UI.getCurrent().navigate(MainView.class);

        } catch (AuthenticationException e) {
            Notification.show("Wrong credentials!");
        }
    }

}
