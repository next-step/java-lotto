package lotto.domain.prize;

import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MatchResultTest {
    @DisplayName("매치된 로또 결과가있을경우 MatchResult객체를 만든다")
    @Test
    public void should_make_object_when_match_map_isNotEmpty() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = new HashMap<LottoPrize, Long>() {{
                put(LottoPrize.FIRST, 1L);
        }};
        Money money = Money.of(1000);

        //act
        MatchResult matchResult = MatchResult.of(matchMap, money);

        //assert
        assertThat(matchResult.getMatchResult().size()).isEqualTo(1);
    }

    @DisplayName("Money null이면 IllegalArgumentException이 발생한다")
    @Test
    public void should_throw_exception_money_null() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = new HashMap<LottoPrize, Long>() {{
            put(LottoPrize.FIRST, 1L);
        }};
        Money money = null;

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(()
                -> MatchResult.of(matchMap, money));
    }

    @DisplayName("매치된 로또 결과가 null이면 IllegalArgumentException이 발생한다")
    @Test
    public void should_throw_exception_null_or_empty_match_map() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = null;
        Money money = Money.of(1000);

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(()
                -> MatchResult.of(matchMap, money));
    }

    @DisplayName("매치된 로또 결과가 있을경우 match count를 반환한다")
    @Test
    public void should_get_match_count() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = new HashMap<LottoPrize, Long>() {{
            put(LottoPrize.FIRST, 1L);
        }};
        MatchResult matchResult = MatchResult.of(matchMap, Money.of(1000));

        //act
        int matchCount = matchResult.matchCount(LottoPrize.FIRST);

        //assert
        assertThat(matchCount).isEqualTo(1);
    }

    @DisplayName("매치된 로또 결과가 없을경우 match count를 반환한다")
    @Test
    public void should_not_get_match_count() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = new HashMap<LottoPrize, Long>() {{
            put(LottoPrize.FIRST, 1L);
        }};
        MatchResult matchResult = MatchResult.of(matchMap, Money.of(1000));

        //act
        int matchCount = matchResult.matchCount(LottoPrize.SECOND);

        //assert
        assertThat(matchCount).isEqualTo(0);
    }

    @DisplayName("매치된 로또 결과의 수익률을 계산한다")
    @Test
    public void should_calculate_earning() throws Exception {
        //arrange
        Map<LottoPrize, Long> matchMap = getLottoPrizeLongMap();
        Money money = Money.of(14_000);
        MatchResult matchResult = MatchResult.of(matchMap, money);

        double expectedRate = getExpectedRate(matchMap, money);

        //act
        double rate = matchResult.calculateEarningsRate();

        //assert
        assertThat(rate).isEqualTo(expectedRate);
    }

    private Map<LottoPrize, Long> getLottoPrizeLongMap() {
        return new HashMap<LottoPrize, Long>() {{
            put(LottoPrize.FOURTH, 1L);
            put(LottoPrize.THIRD, 1L);
        }};
    }

    private double getExpectedRate(Map<LottoPrize, Long> matchMap, Money money) {
        int expectedPrizeMoneyAmount = matchMap.keySet().stream()
                .map(LottoPrize::getPrizeMoneyAmount)
                .reduce(0, Integer::sum);
        return (double) expectedPrizeMoneyAmount / money.getAmount();
    }
}