package Assignment;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Rajeev Nagarwal on 2/14/2017.
 */
public class Test {
    public static void main(String[] args)
    {
        //generateData();
        Storage.storeMaps(2);

    }
    public static void generateData()
    {
        Dataset.generate();
    }
    public static void experiment(int no_of_ones)
    {
        BitSet bf = new BitSet(TableSize.tablesize+1);
        HashSet<Integer> set = new HashSet<>();
        while(set.size()!=no_of_ones)
        {
            Random random = new Random();
            int index = random.nextInt(TableSize.tablesize-1)+1;
            if(!set.contains(index)) {
                set.add(index);
                bf.set(index);
            }
        }
        //System.out.println("size:"+set.size());
        HashMap<Boolean,Integer> map = new HashMap<Boolean,Integer>();
        for(int i=1;i<bf.size();i++)
        {
            System.out.println(bf.get(i));
        }
    }



}
