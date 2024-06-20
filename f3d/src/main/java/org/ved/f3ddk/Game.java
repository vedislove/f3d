package org.ved.f3ddk;

import org.ved.f3ddk.filemanager.Filemanager;
import org.ved.f3ddk.graphics.Window;

public class Game {
    public Window win;

    public Game(){
        Filemanager.init();
        win = new Window();
    }
}
