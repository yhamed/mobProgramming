package com.rainbow.mobProgramming;

import java.awt.*;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;

public class Notify {


    public void sendNotification(String msg) throws AWTException, MalformedURLException{
        if (SystemTray.isSupported()) {
            displayTray(msg);
        } else {
            System.err.println("System tray not supported!");
        }
    }
    public void displayTray(String msg) throws AWTException, MalformedURLException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage(msg, "notification demo", MessageType.INFO);
    }
}
