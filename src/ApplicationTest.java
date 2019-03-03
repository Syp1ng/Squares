import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class ApplicationTest {
    @Test
    public void TestNumber(){
        SquaresSharing21 s = new SquaresSharing21(1, 779000, 780000,1);
        s.start();
        try {
            s.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Example Number
        Assertions.assertTrue(SquaresSharing21.getResult().contains("779131/913177")|| SquaresSharing21.getResult().contains("913177/779131"));

    }
    @Test
    public void TestPerformance(){
        long startTime;
        long stopTime;
        int start =0;
        int stop = 780000;
        startTime= System.currentTimeMillis();
        SquaresSharing21 s = new SquaresSharing21(1, start, stop,1);
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
        SquaresSharing21[] threadsArray = new SquaresSharing21[cores];
        for(int i=0;i<cores;i++){
            threadsArray[i] = new SquaresSharing21(i+1,start,stop,cores);
            start++;
        }
        for(SquaresSharing21 t:threadsArray){
            t.start();
        }
        try{
            for (SquaresSharing21 t:threadsArray)t.join();
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