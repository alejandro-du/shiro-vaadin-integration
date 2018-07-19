package org.vaadin.shiro.demo;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class View2View extends VerticalLayout {

    public View2View() {
        add(new Text("View 2"));
    }

}
