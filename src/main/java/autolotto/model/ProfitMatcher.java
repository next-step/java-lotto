package autolotto.model;

import java.util.HashMap;
import java.util.Map;

public class ProfitMatcher {

    private static final Map<Integer, Float>  matchProfitList = new HashMap<Integer, Float>(){
        {
            put(3,5000.0f);
            put(4,50000.0f);
            put(5,1500000.0f);
            put(6,2000000000.0f);
        }
    };

    public static float getMatchProfit(int matchingNumber, int matchingCount){
        return matchProfitList.get(matchingNumber) * matchingCount;
    }

}
