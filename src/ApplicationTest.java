import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;


class ApplicationTest {
    @Test
    public void TestNumber(){
        SharesSharing21 s = new SharesSharing21(1, 779000, 780000,1);
        s.start();
        try {
            s.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Example Number
        Assertions.assertTrue(SharesSharing21.getResult().contains("779131/913177")||SharesSharing21.getResult().contains("913177/779131"));

    }
    @Test
    public void TestPerformance(){
        long startTime;
        long stopTime;
        int start =0;
        int stop = 780000;
        startTime= System.currentTimeMillis();
        SharesSharing21 s = new SharesSharing21(1, start, stop,1);
        s.start();
        try {
            s.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopTime = System.currentTimeMillis();
        long test1 = stopTime-startTime;

        startTime = System.currentTimeMillis();
        int cores = Runtime.getRuntime().availableProcessors();
        SharesSharing21[] threadsArray = new SharesSharing21[cores];
        for(int i=0;i<cores;i++){
            threadsArray[i] = new SharesSharing21(i+1,start,stop,cores);
            start++;
        }
        for(SharesSharing21 t:threadsArray){
            t.start();
        }
        try{
            for (SharesSharing21 t:threadsArray)t.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopTime=System.currentTimeMillis();
        long test2 = stopTime-startTime;
        System.out.println(test1+"/"+test2 +" ms");

        Assertions.assertTrue(test1>test2);

    }

}