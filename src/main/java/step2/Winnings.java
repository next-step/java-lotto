package step2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Winnings {

    private final Map<Integer, Integer> winnings;
    public Winnings() {
        winnings = new HashMap<>();
        winnings.put(3, 0);
        winnings.put(4, 0);
        winnings.put(5, 0);
        winnings.put(6, 0);
    }

    public void addLottoValue(int key){
        if (checkLottoKey(key)){
            int val = winnings.get(key);
            winnings.put(key, val + 1);
        }
    }

    public void printWinnings(){
        for (Integer key : winnings.keySet()) {
            int value = winnings.get(key);
            System.out.println(key+"개 일치 ("+new Prize(key).findPrizeByWinningCount()+"원)- "+value+"개");
        }
    }

    public int getPrize(){
        int prize = 0;
        for (Integer key : winnings.keySet()) {
            int value = winnings.get(key);
            PrizeType type = PrizeType.findPrizeType(key);
            prize += type.calculate(value);
        }
        return prize;
    }

    private boolean checkLottoKey(int key){
        return key > 2;
    }
}
