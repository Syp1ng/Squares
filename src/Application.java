public class Application {

    public static void main(String[] args) {
       int cores = Runtime.getRuntime().availableProcessors();
        SquaresSharing21[] threadsArray = new SquaresSharing21[cores];
        int start= 0;
        int stop= 780000;
        for(int i=0;i<cores;i++){
            threadsArray[i] = new SquaresSharing21(i+1,start,stop,cores);
            start++;
        }
        for(SquaresSharing21 t:threadsArray){
            t.start();
        }

    }

}
