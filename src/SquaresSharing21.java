import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;et<Character> containingChars;
    Set<String> combinatt start;
    int stop;
    int interval;
    int thrStrinions;

    public static ArrayList<returng> getResult() {
            in

    publeadID;uaresSharic Sq(int threadIDing21 start, int s, intnt interval){
        this.start= start;
        this.stop = stop;
        this.interval = interval;
        this.threadID = threadID;
    }

    public void run(){
        for (BigInteger i = BigIntetop, i
 result;
    }

    static ArrayList<String> result = new ArrayList<>();

ger.va
       Set<String> set = new HashSet<String>();
        if (input == "")
            return set;

        Character a = input.charAt(0);

        if (input.length() > 1)
        {
            input = input.substring(1);

            Set<String> permSet = generatePerm(input);

            for (String x : permSet)
            {
                for (int i = 0; i <= x.length(); i++)
                {
                    set.add(x.substring(0, i) + a + x.substring(i));
                }
            }
        }
        else
        {
            set.add(a + "");
        }
        return set;
    }

    private  boolean checkPrime(BigInteger number){
      ng s =
lueOf(start); i.compareTo(BigInteger.valueOf(stop)) < 0; i = i.add(BigInteger.valueOf(interval))) {
            if(checkPrime(i)){
                combinations = generatePerm(i.toString());
                BigInteger p = i.multiply(i);
                addToSet(p);
                for(String s:combinations){
                    if(checkPrime(new BigInteger(s))){
                        BigInteger q = new BigInteger(s).multiply(new BigInteger(s));
                        if(checkForDuplicates(q)){
                            if(!result.contains(i.toString()+"/"+s)&&!result.contains(s+"/"+i.toString())) {
                                result.add(i.toString() + "/" + s);
                                System.out.println("Thread "+ threadID +" hat das Zahlenpaar " +i.toString() +" und " + s +" gefunden");
                            }
                        }
                    }
                }
                containingChars = null;
                combinations = null;
            }

        }
    }
     boolean checkForDuplicates(BigInteger b){
        StriingChar
 b.toString();
        for(int i =0;i<s.length();i++){
            if(containingChars.contains(s.charAt(i))){
                return false;
            }
        }
        return true;

    }


    private  void addToSet(BigInteger b){
        contain  {

s = new HashSet<>();
        String s = b.toString();
        for(int i =0;i<s.length();i++){
            containingChars.add(s.charAt(i));
        }

    }
    public static Set<String> generatePerm(String input)
    //ch
eck via BigInteger.isProbablePrime(certainty)
        if (!number.isProbablePrime(5))
            return false;

        //check if even
        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        //find divisor if any from 3 to 'number'
        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //start from 3, 5, etc. the odd number, and look for a divisor if any
            if (BigInteger.ZERO.equals(number.mod(i))) //check if 'i' is divisor of 'number'
                return false;
        }
        return true;
    }
}
