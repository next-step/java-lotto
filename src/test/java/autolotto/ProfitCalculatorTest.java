package autolotto;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.HashMap;

public class ProfitCalculatorTest {

    @Test
    @DisplayName("수익률 계산을 제대로 하는가")
    public void calculateProfit(){
        HashMap matchingList = new HashMap<Integer,Integer>();

        matchingList.put(3,1);
        matchingList.put(4,1);
        matchingList.put(5,1);
        matchingList.put(6,1);

        assertEquals(PorfitCalculator.calculate(10000, matchingList),200155.5);
    }
}
