import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Application {
    static HashSet<Character> containingChars;
    static HashSet<String> testedCombinations;
    static Set<String> combinations;
    public static void main(String[] args) {
        testedCombinations = new HashSet<>();

            for (BigInteger i = BigInteger.valueOf(779130); i.compareTo(BigInteger.valueOf(779200)) < 0; i = i.add(BigInteger.ONE)) {
            if(checkPrime(i)&& !testedCombinations.contains(i.toString())){
                System.out.println(i.toString());
                combinations = generatePerm(i.toString());
                BigInteger p = i.multiply(i);
                addToSet(p);
                for(String s:combinations){
                    if(checkPrime(new BigInteger(s))){
                        BigInteger q = new BigInteger(s).multiply(new BigInteger(s));
                        if(checkForDuplicates(q)){
                            System.out.println("nice"+s);
                        }
                    }
                }
                containingChars = null;
                testedCombinations.addAll(combinations);
                combinations = null;
            }

        }

    }

    static boolean checkForDuplicates(BigInteger b){
        String s = b.toString();
        for(int i =0;i<s.length();i++){
            if(containingChars.contains(s.charAt(i))){
                return false;
            }
        }
        return true;

    }


    private static void addToSet(BigInteger b){
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

    private static boolean checkPrime(BigInteger number){
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
