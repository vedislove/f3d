package org.ved.f3ddk.filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.ved.f3ddk.graphics.Window;

public class Filemanager {
    private static boolean flag;

    // Init
    public static void init(){
        try {
        // Create file on 1st startup
            File conf = new File("config.cfg");
            if (conf.createNewFile()) {
              System.out.println("File created: " + conf.getName());
              try {
                FileWriter wrt = new FileWriter("config.cfg");
                wrt.write("width " + "640" + "\nheight " + "480" + "\nfullscreen " + "0" + "\nEND " + "1");
                wrt.close();
                System.out.println("Successfully wrote to the file.");

                Filemanager.interpretator("config.cfg"); // READING

            // Error
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }


            } else {
            // Read file
              System.out.println("File already exists: " + conf.getName());
              Filemanager.interpretator("config.cfg");
            }

            // Error
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }      
    } // Init END



    public static void interpretator(String path) throws FileNotFoundException{
      // Read file
        Config cfgc = new Filemanager.Config();
  
      // Reading proc
        File myObj = new File(path);
        Scanner myReader = new Scanner(myObj);
        int lng = 0;
  
      // Calculating lines {else it is doesn't working :3 idk}
        while(myReader.hasNextLine()){
          myReader.nextLine();
          lng++;
        }
        myReader.close();
        lng= lng-2;
        System.out.println(lng);
  
      // Start reading
        System.out.println("Running: " + path);
        for(int i=0; i <= lng; i++){
          System.out.println("Line"+ "[" + i + "]" + ":");
          
        // Vars
          // WIDTH
          if(cfgc.readIntVar(path, i).name.equals("width")){
            Window.setWidth(cfgc.readIntVar(path, i).value);
            System.out.print("Window width = " + Window.getWidth() + "\n");
          } else
          // HEIGHT
          if(cfgc.readIntVar(path, i).name.equals("height")){
            Window.setHeight(cfgc.readIntVar(path, i).value);
            System.out.print("Window height = " + Window.getHeight() + "\n");
          } else
          // FULLSCREEN
          if(cfgc.readIntVar(path, i).name.equals("fullscreen")){
            if(cfgc.readIntVar(path, i).value == 1){
              flag = true;
            }
            Window.setFullscreen(flag);
            System.out.print("Window fullscreen = " + Window.getFullscreen() + "\n");
  
          } else if(cfgc.readIntVar(path, i).name.equals("END")){
            System.out.println("END" + cfgc.readIntVar(path, i).value);
            break;
          }
        } // Loop END
        System.out.println("Reading done");
      } // INTERPRETATOR END



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
