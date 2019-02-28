import java.util.HashSet;

public class Application {

    public static void main(String[] args) {
       int cores = Runtime.getRuntime().availableProcessors();
        SharesSharing21[] threadsArray = new SharesSharing21[cores];
        int start= 0;
        int stop= 780000;
        for(int i=0;i<cores;i++){
            threadsArray[i] = new SharesSharing21(i+1,start,stop,cores);
            start++;
        }
        for(SharesSharing21 t:threadsArray){
            t.start();
        }

    }

}
