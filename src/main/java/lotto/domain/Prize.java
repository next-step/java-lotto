package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Prize {

    private Map<Rank, Integer> prize;
    private BigDecimal totalWinningMoney;
    private double yield;

    public Prize(Lottos lottos, Lotto lastLottoNumber) {
        this.prize = generatorState();
        getWinningResult(lottos, lastLottoNumber);
    }

    private Map<Rank, Integer> generatorState(){
        Map<Rank, Integer> prize = new HashMap<>();
        for(Rank tempPrize : Rank.values()){
            prize.put(tempPrize,0);
        }
        return prize;
    }

    private void getWinningResult( Lottos lottos, Lotto lastLottoNumber) {
        for (Lotto paylotto : lottos.getLottos()) {
            int matchNumber = paylotto.countNumbers(lastLottoNumber);
            countResult(matchNumber, paylotto.anyMatch(lastLottoNumber.getBonus()));
        }
    }

    private void countResult(int matchNumber, boolean bonus) {
        prize.put(Rank.converterPrize(matchNumber, bonus), prize.get(Rank.converterPrize(matchNumber, bonus)) + 1);
    }


    private BigDecimal calTotalWinningMoney() {
        totalWinningMoney = new BigDecimal("0");
        for (Rank type : Rank.values()) {
            BigDecimal count = BigDecimal.valueOf(prize.get(type));
            BigDecimal unit = BigDecimal.valueOf(type.getMoney());
            BigDecimal round = count.multiply(unit);
            totalWinningMoney = totalWinningMoney.add(round);
        }
        return totalWinningMoney;
    }

    public double calYield(int totalPrice) {
        yield = calTotalWinningMoney().doubleValue()/totalPrice;
        return yield;
    }

    public Map<Rank, Integer> getPrize() {
        return prize;
    }
}
