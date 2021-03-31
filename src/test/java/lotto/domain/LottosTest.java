package lotto.domain;

import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("구매금액에 따른 로또 구매개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1000,1", "5000,5"})
    void of(int amount, int expectedPurchaseCount) {
        // given
        Money money = Money.from(amount);

        // when
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), money);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(expectedPurchaseCount);
    }

    @DisplayName("당첨번호와 보너스 번호, 당첨등수를 입력하면 몇개가 당첨되었는지 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,43,44,45:42:3:false:1", "1,2,3,4,44,45:43:4:false:1", "1,2,3,4,5,45:44:5:false:1",
            "1,2,3,4,5,45:6:5:true:1", "1,2,3,4,5,6:45:6:false:1"}, delimiter = ':')
    void getRankCount(String purchaseNumber, int bonusNum, int matchCount, boolean matchBonus, int expectedRankCount) {
        // given
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), Money.from(1000));
        Rank rank = Rank.valueOf(matchCount, matchBonus);
        Number bonusNumber = Number.from(bonusNum);

        Set<Integer> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(",")))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());

        Lotto prizeLotto = Lotto.from(numbers);

        // when
        int rankCount = lottos.getRankCount(prizeLotto, bonusNumber, rank);

        // then
        assertThat(rankCount).isEqualTo(expectedRankCount);
    }
}
