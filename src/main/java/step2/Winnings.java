package step2;

import java.util.*;

public class Winnings {

    private final Map<Prize, Integer> winnings;

    public Winnings() {
        this.winnings = new EnumMap<>(Prize.class);
        winnings.put(Prize.UNKNOWN, 0);
        winnings.put(Prize.THREE, 0);
        winnings.put(Prize.FOUR, 0);
        winnings.put(Prize.FIVE, 0);
        winnings.put(Prize.SIX, 0);
    }

    public void addLottoValue(Prize prize){
        int val = winnings.get(prize);
        winnings.put(prize, val + 1);
    }

    public void printWinnings(){
        for (Prize prize : winnings.keySet()) {
            int count = winnings.get(prize);
            System.out.println(prize.printValue() + count + "개");
        }
    }

    public int getTotal(){
        int total = 0;
        for (Prize key : winnings.keySet()) {
            int value = winnings.get(key);
            total += key.calculatePrize(key, value);
        }
        return total;
    }

}
