package Assignment;

import java.util.ArrayList;

/**
 * Created by Rajeev Nagarwal on 2/14/2017.
 */
public class Table {
    public static ArrayList<Record> records;
    public Table()
    {
        records = new ArrayList<Record>();
    }
    public void addRecord(Record record)
    {
        records.add(record);
    }


}
