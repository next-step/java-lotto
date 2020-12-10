package autolotto.model;

import java.util.HashMap;
import java.util.Map;

public class MatchingNumbers {

    private final Map<Integer,Integer> numbers = new HashMap<Integer, Integer>() {
        {
            for (int i = 3; i < 7; i++) {
                put(i,0);
            }
        }
    };

    public void putMatchingNumbers(int matchCount){
        if (matchCount != 0) {
            numbers.put(matchCount, numbers.get(matchCount) + 1);
        }
    }

    public int getMatchingCount(int matchingNumber) {
        System.out.println(numbers.get(matchingNumber));
        return numbers.get(matchingNumber);
    }

}
