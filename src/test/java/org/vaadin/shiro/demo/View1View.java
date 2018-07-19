package org.vaadin.shiro.demo;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class View1View extends VerticalLayout {

    public View1View() {
        add(new Text("View 1"));
    }

}
