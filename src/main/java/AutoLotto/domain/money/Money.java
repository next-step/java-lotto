package AutoLotto.domain.money;

import AutoLotto.domain.play.PlayLottoResult;
import AutoLotto.domain.play.Rank;

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

    public Double makeProfitRateBy(int buzzMoney) {
        String left = Integer.toString(buzzMoney);
        String right = Integer.toString(money);
        Double profitRate = divideToDecimal(left, right);
        return profitRate;
    }

    public Double makePlayProfitRateBy(PlayLottoResult playLottoResult) {
        return makeProfitRateBy(Rank.createBuzzMoney2(playLottoResult));
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
