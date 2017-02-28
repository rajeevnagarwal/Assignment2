package Assignment;

import java.util.Random;

/**
 * Created by kushagra on 26-02-2017.
 */
public class Expt1 {

    public void createbf(){
        Query.bf.clear();
        for(int i=0;i<TableSize.tablesize;i++){
            Query.bf.add(0);
        }
        Random rand = new Random();
        int  n;
        for(int i=0;i<100000;i++){
            n= rand.nextInt(TableSize.tablesize-1) + 0;
            if(Query.bf.get(n)==1){
                Query.bf.set(n/2, 1);
            }
            else {
                Query.bf.set(n, 1);
            }
        }
    }

    public void executenoindex(){

        for(int i=0;i<TableSize.tablesize;i++){

            if(Query.bf.get(i)==1){

            }

        }
    }

    public void executebitslice(){

    }
}
