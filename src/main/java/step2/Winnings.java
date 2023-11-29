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

    public void addLottoValue(int key){
        if (checkLottoKey(key)){
            int val = winnings.get(Prize.of(key));
            winnings.put(Prize.of(key), val + 1);
        }
    }

    public void printWinnings(){
        for (Prize key : winnings.keySet()) {
            int value = winnings.get(key);
            System.out.println(key.ordinal()+"개 일치 ("+ key.calculatePrize(key, 1)+"원)- "+value+"개");
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

    private boolean checkLottoKey(int key){
        return key > 2;
    }
}
