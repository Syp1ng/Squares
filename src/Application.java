public class Application {

    public static void main(String[] args) {
       //int cores = Runtime.getRuntime().availableProcessors();
        int cores = 4;
        SharesSharing21[] threadsArray = new SharesSharing21[cores];
        int start= 779121;
        int stop= 1000000000;
        for(int i=0;i<cores;i++){
            threadsArray[i] = new SharesSharing21(i+1,start,stop,cores);
            start++;
        }
        for(SharesSharing21 t:threadsArray){
            t.start();
        }

    }

}
