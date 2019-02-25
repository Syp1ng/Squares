import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    @Test
    public void TestNumber(){
        SharesSharing21.testedCombinations = new HashSet<>();
        SharesSharing21 s = new SharesSharing21(1, 0, 800000,1);
        s.start();
        try {
            s.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void TestPerformance(){
        long startTime;
        long stopTime;
        int start =0;
        int stop = 80000;
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
        System.out.println(test1+"/"+test2);

        Assertions.assertTrue(test1>test2);

    }

}