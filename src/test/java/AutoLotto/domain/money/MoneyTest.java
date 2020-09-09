package AutoLotto.domain.money;

import AutoLotto.domain.play.PlayLottoResult;
import AutoLotto.domain.play.Rank;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @Test
    void canMakeMoney() {
        Money money1 = new Money(0);
        Money money2 = new Money(100);
        assertThat(money1.makeMoney()).isEqualTo(0);
        assertThat(money2.makeMoney()).isEqualTo(100);
    }

    @Test
    void checkPlusProfitBy() {
        Money money1 = new Money(14000);
        Money money2 = new Money(1400);
        assertThat(money1.isPlusProfitBy(5000)).isEqualTo(false);
        assertThat(money1.isPlusProfitBy(0)).isEqualTo(false);
        assertThat(money2.isPlusProfitBy(5000)).isEqualTo(true);
    }

    @Test
    void canCreateBuzzMoney() {
        Money money = new Money(3000);
        PlayLottoResult result = new PlayLottoResult();
        Map<Rank, Integer> testResult = new HashMap<>();
        testResult.put(Rank.FOURTH, 3);
        testResult.put(Rank.FIRST, 2);
        testResult.put(Rank.NO_MATCH, 1);

        assertThat(money.createBuzzMoney2ForTest(testResult, Rank.FOURTH))
                .isEqualTo(Rank.FOURTH.rankMoney * 3);
        assertThat(money.createBuzzMoney2ForTest(testResult, Rank.NO_MATCH))
                .isEqualTo(Rank.NO_MATCH.rankMoney * 1);
        assertThat(money.createBuzzMoney2ForTest(testResult, Rank.SECOND))
                .isEqualTo(Rank.SECOND.rankMoney * 0);
    }
}
