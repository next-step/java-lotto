package step2.model;

import step2.enums.ExceptionMessage;
import step2.enums.LottoPrize;

import java.util.HashMap;
import java.util.Map;

public class PrizeStatics {

    private final Map<Integer, Integer> prizes = new HashMap<>();

    //로또당첨
    public void prize(int matchCount) {
        prizes.put(matchCount, prizes.getOrDefault(matchCount, 0) + 1);
    }

    //당첨된 숫자의 로또 개수 가져오기
    public int getPrize(int matchCount) {
        return prizes.getOrDefault(matchCount, 0);
    }

    public Map<Integer, Integer> getPrizes() {
        return prizes;
    }

    //현재 총 당첨금액 가져오기
    public int prizeMoney() {
        checkPrize();
        int prizeMoney = 0;
        for (Map.Entry<Integer, Integer> entry : prizes.entrySet()) {
            prizeMoney += LottoPrize.calculateTotalPrize(entry.getKey(), entry.getValue());
        }
        return prizeMoney;
    }

    //로또 당첨번호를 맞춰봤는지 체크한다.
    private void checkPrize() {
        if (prizes.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MATCH_PRIZE.message());
        }
    }
}
