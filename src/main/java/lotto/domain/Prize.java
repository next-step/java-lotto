package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Prize {

    private Map<Rank, Integer> prize;
    private BigDecimal totalWinningMoney;
    private double yield;

    public Prize(Lottos lottos, Lotto lastLottoNumber, Number bonus) {
        this.prize = generatorState();
        getWinningResult(lottos, lastLottoNumber, bonus);
    }

    private Map<Rank, Integer> generatorState(){
        Map<Rank, Integer> prize = new HashMap<>();
        for(Rank tempPrize : Rank.values()){
            prize.put(tempPrize,0);
        }
        return prize;
    }

    private void getWinningResult( Lottos lottos, Lotto lastLottoNumber, Number bonus) {
        for (Lotto paylotto : lottos.getLottos()) {
            int matchNumber = paylotto.countNumbers(lastLottoNumber);
            countResult(matchNumber, paylotto.anyMatch(bonus));
        }
    }

    private void countResult(int matchNumber, boolean isBonus) {
        Rank rank = Rank.converterPrize(matchNumber, isBonus);
        prize.put(rank, prize.get(rank) + 1);
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
