package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMarket {

    private final int PRICE = 1000;
    private LottoMachine machine;
    private LottoList myLottoList;

    public LottoMarket(LottoMachine machine, LottoList list) {
        this.machine = machine;
        this.myLottoList = list;
    }

    public int buy(int money) {
        int count = money / PRICE;
        for (int i = 0; i < count; i++) {
            myLottoList.buyLotto(machine);
        }
        return PRICE * count;
    }

    public Map<Integer,Integer> checkNumToWinner(Lotto winner){
        Map<Integer,Integer> result = new HashMap<>();

        result.put(3,0);
        result.put(4,0);
        result.put(5,0);
        result.put(6,0);

        for(Lotto myLotto : myLottoList.getAll()){
            int matchCount = matchLotto(winner, myLotto);
            putResult(result, matchCount);
        }
        return result;
    }

    private int matchLotto(Lotto winner, Lotto myLotto) {
        int count = 0;
        for(int number : myLotto.getNumbers()){
            count = checkLotto(winner, number, count);
        }
        return count;
    }

    private int checkLotto(Lotto winner, int number, int count) {
        if(winner.getNumbers().contains(number)){
            count++;
        }
        return count;
    }

    private void putResult(Map<Integer, Integer> result, int matchCount) {
        if(matchCount >= 3){
            result.put(matchCount, result.get(matchCount)+1);
        }
    }

}
