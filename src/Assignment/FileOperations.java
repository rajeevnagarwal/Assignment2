package Assignment;

import java.io.*;

/**
 * Created by Rajeev Nagarwal on 2/14/2017.
 */
public class FileOperations {
    public static File openFile(String filename,String extension)
    {
        try {
            String path="";
            if(filename.contains("bitmap")){
                path = "./src/Assignment/Data/BitMap/" + filename + "." + extension;

            }
            else if(filename.contains("bitslice")){
                path = "./src/Assignment/Databitslice/" + filename + "." + extension;

            }
            else {
                path = "./src/Assignment/Data/" + filename + "." + extension;
            }
            File file = new File(path);
            /*if (!file.exists()) {
               return file.createNewFile()?file:null;
            }
            else
            {
                return file;
            }*/
            return file;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static File openFile(String filename,String extension,int flag)
    {
        try {
            String path = "";
            if (flag == 0) {
                path = "./src/Assignment/Data/BitMap/" + filename + "." + extension;
            }
            if (flag == 1) {
                path = "./src/Assignment/Data/BitMapRow/" + filename + "." + extension;
            }

            File file = new File(path);
            /*if (!file.exists()) {
               return file.createNewFile()?file:null;
            }
            else
            {
                return file;
            }*/
            return file;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static BufferedReader openReader(File file)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return reader;

        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    public static BufferedWriter openWriter(File file)
    {
        try
        {
            BufferedWriter writer= new BufferedWriter(new FileWriter(file));
            return writer;

        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }



}
