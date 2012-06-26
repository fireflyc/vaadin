/* 
@VaadinApache2LicenseForJavaFiles@
 */
package com.vaadin.tests.extensions;

import com.vaadin.terminal.AbstractExtension;
import com.vaadin.terminal.gwt.client.ui.helloworldfeature.GreetAgainRpc;
import com.vaadin.terminal.gwt.client.ui.helloworldfeature.HelloWorldRpc;
import com.vaadin.terminal.gwt.client.ui.helloworldfeature.HelloWorldState;
import com.vaadin.ui.Notification;

public class HelloWorldExtension extends AbstractExtension {

    public HelloWorldExtension() {
        registerRpc(new HelloWorldRpc() {
            public void onMessageSent(String message) {
                Notification.show(message);
            }
        });
    }

    @Override
    public HelloWorldState getState() {
        return (HelloWorldState) super.getState();
    }

    public void setGreeting(String greeting) {
        getState().setGreeting(greeting);
        requestRepaint();
    }

    public String getGreeting() {
        return getState().getGreeting();
    }

    public void greetAgain() {
        getRpcProxy(GreetAgainRpc.class).greetAgain();
    }
}