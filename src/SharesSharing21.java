import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SharesSharing21 extends  Thread {

    HashSet<Character> containingChars;
    public static HashSet<String> testedCombinations;
    Set<String> combinations;

    int start;
    int stop;
    int intervall;
    int threadID;

    public SharesSharing21(int threadID, int start, int stop, int intervall){
        this.start= start;
        this.stop = stop;
        this.intervall = intervall;
        this.threadID = threadID;
    }

    public void run(){
        for (BigInteger i = BigInteger.valueOf(start); i.compareTo(BigInteger.valueOf(stop)) < 0; i = i.add(BigInteger.valueOf(intervall))) {
            System.out.println(threadID + " "+ i);
            if(checkPrime(i)&& !testedCombinations.contains(i.toString())){
                System.out.println(threadID + " "+ i);
                combinations = generatePerm(i.toString());
                BigInteger p = i.multiply(i);
                addToSet(p);
                for(String s:combinations){
                    if(checkPrime(new BigInteger(s))){
                        BigInteger q = new BigInteger(s).multiply(new BigInteger(s));
                        if(checkForDuplicates(q)){
                            System.out.println("Thread"+threadID+" hat das Zahlenpaar "+s+" und  "+ i+ " gefunden!");
                        }
                    }
                }
                containingChars = null;
                testedCombinations.addAll(combinations);
                testedCombinations.add(i.toString());
                combinations = null;
            }

        }
    }
     boolean checkForDuplicates(BigInteger b){
        String s = b.toString();
        for(int i =0;i<s.length();i++){
            if(containingChars.contains(s.charAt(i))){
                return false;
            }
        }
        return true;

    }


    private  void addToSet(BigInteger b){
        containingChars = new HashSet<>();
        String s = b.toString();
        for(int i =0;i<s.length();i++){
            containingChars.add(s.charAt(i));
        }

    }
    public static Set<String> generatePerm(String input)
    {
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
        //check via BigInteger.isProbablePrime(certainty)
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
