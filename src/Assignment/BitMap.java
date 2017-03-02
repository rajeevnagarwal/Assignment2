package Assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.util.*;

import static Assignment.FileOperations.openFile;
import static Assignment.FileOperations.openWriter;

/**
 * Created by Rajeev Nagarwal on 3/2/2017.
 */
public class BitMap {
    public HashMap<Integer,BitSet> index;
    public BitMap()
    {
        index = new HashMap<Integer,BitSet>();
    }
    public void populateIndex()
    {
        ArrayList<Record> records = Storage.readRecordsFromFile();
        System.out.println("Size: "+records.size());
        try {
            for (int i = 0; i < records.size(); i++) {
                Record record = records.get(i);
//            System.out.println(index.size());
                if (index.containsKey(record.getSale())) {
                    index.get(record.getSale()).set(record.getID()-1,true);
                } else {
                    index.put(record.getSale(),new BitSet(TableSize.tablesize));
                    index.get(record.getSale()).set(record.getID()-1,true);
                }
            }
            storemap();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public StringBuilder getBitArray()
    {
        String bits = "";
        for(int i=0;i<TableSize.tablesize;i++)
        {
            bits = bits+"0";
        }
        StringBuilder builder = new StringBuilder(bits);
        return builder;

    }
    public void storemap()
    {
        Iterator it = index.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            BitSet set = (BitSet)pair.getValue();
            int count = 0;
            ArrayList<Integer> list = new ArrayList<Integer>();
            int index = 0;
            String filename = pair.getKey()+"";
            System.out.println(filename);
            for(int i=0;i<set.size();i++)
            {
                Integer ind = 0;
                if(set.get(i))
                {
                    ind = 1;
                }
                if(count==BlockSize.blocksizebitmap)
                {
                    list.add(ind);
                    writefile(filename,list,index);
                    list.clear();
                    index = index + 1;
                    count = 0;

                }
                else if(count<BlockSize.blocksizebitmap)
                {
                    list.add(ind);
                    count++;
                }
            }
            if(!list.isEmpty()) {
                writefile(filename, list, index);
                list.clear();
                count = 0;
                index = index + 1;
            }

            it.remove(); // avoids a ConcurrentModificationException
        }
    }
    public void writefile(String filename, ArrayList<Integer> list,int index)
    {
        String filenamefinal = filename+"_"+index;
        File file = openFile(filenamefinal,"txt",0);
        BufferedWriter writer = openWriter(file);
        try {
            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i));
                writer.newLine();
            }
            writer.write("next: " + (index + 1) + "\n");
            writer.newLine();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
