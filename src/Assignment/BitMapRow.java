package Assignment;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

/**
 * Created by Rajeev Nagarwal on 3/2/2017.
 */
public class BitMapRow {
    public HashMap<Integer,ArrayList<Integer>> index;
    public BitMapRow()
    {
        index = new HashMap<Integer,ArrayList<Integer>>();

    }
    /*public void populateIndex()
    {
        ArrayList<Record> records = Storage.readRecordsFromFile();
        System.out.println("Size: "+records.size());
        try {
            for (int i = 0; i < records.size(); i++) {
                Record record = records.get(i);
//            System.out.println(index.size());
                if (index.containsKey(record.getSale())) {
                    index.get(record.getSale()).add();
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

    }*/

}
