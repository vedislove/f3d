package org.ved.f3ddk.graphics;

import javax.swing.*;

public class Window {
    private static JFrame frame;
    private static boolean fullscreen;
    private static int width;
    private static int height;

    public Window(){
        frame = new JFrame();
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if(fullscreen){
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            frame.setUndecorated(true);
            frame.setVisible(true);
        }
    }

    public static void setWidth(int width){
        Window.width = width;
    }

    public static void setHeight(int height){
        Window.height = height;
    }

    public static void setFullscreen(boolean flag){
        Window.fullscreen = flag;
    }

    public static JFrame getWindow(){
        return frame;
    }

    public static boolean getFullscreen(){
        return fullscreen;
    }

    public static int getWidth(){
        return width;
    }

    public static int getHeight(){
        return height;
    }
}
