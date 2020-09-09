package AutoLotto.domain.money;

import AutoLotto.domain.play.PlayLottoResult;
import AutoLotto.domain.play.Rank;

import java.util.Map;
import java.util.Objects;

import static AutoLotto.utils.CheckDivideBy.divideToDecimal;
import static AutoLotto.utils.CheckString.isNullOrBlank;

public class Money {

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int makeMoney() {
        String value = Integer.toString(money);
        if(isNullOrBlank(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    public boolean isPlusProfitBy(int buzzMoney) {
        Double profitRate = makeProfitRateBy(buzzMoney);
        return profitRate >= 1;
    }

    public String isPlayPlusProfitBy(PlayLottoResult playLottoResult) {
        if (isPlusProfitBy(createBuzzMoneyAll(playLottoResult))) {
            return "이득이";
        }
        return "손해";
    }

    public Double makeProfitRateBy(int buzzMoney) {
        String left = Integer.toString(buzzMoney);
        String right = Integer.toString(money);
        Double profitRate = divideToDecimal(left, right);
        return profitRate;
    }

    public Double makePlayProfitRateBy(PlayLottoResult playLottoResult) {
        return makeProfitRateBy(createBuzzMoneyAll(playLottoResult));
    }

    public int createBuzzMoneyAll(PlayLottoResult playLottoResult) {
        int sum = 0;
        for (Rank rank : Rank.values()) {
            sum += createBuzzMoney2(playLottoResult, rank);
        }
        return sum;
    }

    public int createBuzzMoney2(PlayLottoResult playLottoResult, Rank rank) {
        int sum = 0;
        if (playLottoResult.getResult().containsKey(rank)) {
            return sum += playLottoResult.getCountByRank(rank) * rank.rankMoney;
        }
        return sum;
    }

    public int createBuzzMoney2ForTest(Map<Rank,Integer> map, Rank rank) {
        int sum = 0;
        if (map.containsKey(rank)) {
            return sum += map.get(rank) * rank.rankMoney;
        }
        return sum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
