package org.vaadin.shiro.demo;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.apache.shiro.SecurityUtils;

@Route
public class MainView extends VerticalLayout {

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        if (SecurityUtils.getSubject().isAuthenticated()) {
            showViewList();
        } else {
            showLoginForm();
        }
    }

    private void showLoginForm() {
        UI.getCurrent().navigate(LoginView.class);
    }

    private void showViewList() {
        add(
                new RouterLink("View 1", View1View.class),
                new RouterLink("View 2", View2View.class),
                new Button("Log out", e -> logOut())
        );
    }

    private void logOut() {
        SecurityUtils.getSubject().logout();
        UI.getCurrent().navigate(MainView.class);
        UI.getCurrent().getPage().executeJavaScript("location.reload();");
    }

}
