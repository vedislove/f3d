package org.ved.f3ddk.filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.ved.f3ddk.graphics.Window;

public class Filemanager {

    public static void init(){
        try {
        // Create file on 1st startup
            File conf = new File("config.cfg");
            if (conf.createNewFile()) {
              System.out.println("File created: " + conf.getName());
              try {
                FileWriter wrt = new FileWriter("config.cfg");
                wrt.write("width:" + "640" + "\nheight:" + "480" + "\nfullscreen:" + "1");
                wrt.close();
                System.out.println("Successfully wrote to the file.");

                // Read file
              System.out.println("File already exists: " + conf.getName());
              Config cfgc = new Filemanager.Config();

            // Reading proc
              File myObj = new File("config.cfg");
              Scanner myReader = new Scanner(myObj);
              int lng = 0;

            // Calculating lines {else it is doesn't working :3 idk}
              while(myReader.hasNextLine())
                myReader.nextLine();
                lng++;
              myReader.close();
              System.out.println(lng);

            // Start reading
              System.out.println("Running: config.cfg");
              for(int i=0; i <= lng; i++){
                System.out.println("Line"+ "[" + i + "]" + ":");

              // Vars
                // WIDTH
                if(cfgc.readIntVar("config.cfg", i).name.equals("width")){
                  Window.setWidth(cfgc.readIntVar("config.cfg", i).value);
                  System.out.print("Window width = " + Window.getWidth() + "\n");
                } else
                // HEIGHT
                if(cfgc.readIntVar("config.cfg", i).name.equals("height")){
                  Window.setHeight(cfgc.readIntVar("config.cfg", i).value);
                  System.out.print("Window height = " + Window.getHeight() + "\n");
                // STOP
                } else{
                  break;
                }
              } // Loop END
            // Error
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }


            // READING
            } else {
            // Read file
              System.out.println("File already exists: " + conf.getName());
              Config cfgc = new Filemanager.Config();

            // Reading proc
              File myObj = new File("config.cfg");
              Scanner myReader = new Scanner(myObj);
              int lng = 0;

            // Calculating lines {else it is doesn't working :3 idk}
              while(myReader.hasNextLine())
                myReader.nextLine();
                lng++;
              myReader.close();
              System.out.println(lng);

            // Start reading
              System.out.println("Running: config.cfg");
              for(int i=0; i <= lng; i++){
                System.out.println("Line"+ "[" + i + "]" + ":");

              // Vars
                // WIDTH
                if(cfgc.readIntVar("config.cfg", i).name.equals("width")){
                  Window.setWidth(cfgc.readIntVar("config.cfg", i).value);
                  System.out.print("Window width = " + Window.getWidth() + "\n");
                } else
                // HEIGHT
                if(cfgc.readIntVar("config.cfg", i).name.equals("height")){
                  Window.setHeight(cfgc.readIntVar("config.cfg", i).value);
                  System.out.print("Window height = " + Window.getHeight() + "\n");
                // STOP
                } else{
                  break;
                }
              } // Loop END
            } // Read END
            // Error
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }      
    } // Init END




    public static class Config{

    // Var classes :3
      public class intVar{
        public String name;
        public int value;
      }

      // Int
        public intVar readIntVar(String path, int line){
            intVar var = new intVar();
            try {
                File myObj = new File(path);
                Scanner myReader = new Scanner(myObj);
                // Reading proc
                for(int i=0; i <= line; i++){
                  if(i==line){
                    var.name = myReader.next();
                    var.value = myReader.nextInt();
                  }
                  myReader.nextLine();
                }

                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return var;
        } // read END
    }
}
