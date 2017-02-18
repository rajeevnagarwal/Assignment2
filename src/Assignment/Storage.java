package Assignment;

import jdk.nashorn.internal.ir.Block;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

import static Assignment.FileOperations.openFile;
import static Assignment.FileOperations.openWriter;

/**
 * Created by Rajeev Nagarwal on 2/14/2017.
 */
public class Storage {
    public static void store(ArrayList<Record> records)
    {
        int count = 0;
        ArrayList<Record> list = new ArrayList<Record>();
        for(int i=0;i<records.size();i++)
        {
            Record record = records.get(i);
            if(count== BlockSize.blocksize)
            {
                list.add(record);
                writeToFile(list);
                list.clear();
                count = 0;
            }
            else if(count<BlockSize.blocksize)
            {
                list.add(record);
                count++;
            }


        }
        if(!list.isEmpty()) {
            writeToFile(list);
        }

    }
    public static void writeToFile(ArrayList<Record> list)
    {
        String filename = list.get(0).getID()+"";
        File file = openFile(filename,"csv");
        System.out.println(file);
        BufferedWriter writer = openWriter(file);
        try {
            for (int i = 0; i < list.size(); i++) {
                Record record = list.get(i);
                writer.write(record.getID() + "," + record.getName() + "," + record.getSale()+"\n");
            }
            writer.write("next: "+(list.get(list.size()-1).getID()+1)+"\n");
            writer.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }


}
