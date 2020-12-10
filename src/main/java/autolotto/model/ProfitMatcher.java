package autolotto.model;

import java.util.HashMap;
import java.util.Map;

public class ProfitMatcher {

    private static final Map<Integer, Integer>  matchProfitList = new HashMap<Integer, Integer>(){
        {
            put(3,5000);
            put(4,50000);
            put(5,1500000);
            put(6,2000000000);
        }
    };

    public static int getMatchProfit(int matchingNumber, int matchingCount){
        return matchProfitList.get(matchingNumber) * matchingCount;
    }

}
