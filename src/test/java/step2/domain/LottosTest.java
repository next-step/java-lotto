package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.generator.TestLottoNumberGenerator;

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

    @DisplayName("당첨번호와 당첨등수를 입력하면 몇개가 당첨되었는지 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,43,44,45:3:1", "1,2,3,4,44,45:4:1", "1,2,3,4,5,45:5:1", "1,2,3,4,5,6:6:1"}, delimiter = ':')
    void getPrizeCount(String purchaseNumber, int matchCount, int expectedPrizeCount) {
        // given
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), Money.from(1000));
        Prize prize = Prize.findPrize(matchCount);

        Set<Number> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(",")))
                .stream()
                .map(i -> Number.from(Integer.valueOf(i)))
                .collect(Collectors.toSet());
        Lotto prizeLotto = Lotto.from(numbers);

        // when
        int prizeCount = lottos.getPrizeCount(prizeLotto, prize);

        // then
        assertThat(prizeCount).isEqualTo(expectedPrizeCount);
    }

    @DisplayName("당첨번호를 입력하면 총 상금을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,42,43,44,45:0", "1,2,3,43,44,45:5000", "1,2,3,4,44,45:50000", "1,2,3,4,5,45:1500000",
            "1,2,3,4,5,6:2000000000"}, delimiter = ':')
    void getTotalPrizeAmount(String purchaseNumber, int expectedTotalPrizeAmount) {
        // given
        Set<Number> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(",")))
                .stream()
                .map(i -> Number.from(Integer.valueOf(i)))
                .collect(Collectors.toSet());
        Lotto prizeLotto = Lotto.from(numbers);
        Lottos lottos = Lottos.of(new TestLottoNumberGenerator(), Money.from(1000));

        // when
        int totalPrizeAmount = lottos.getTotalPrizeAmount(prizeLotto);

        // then
        assertThat(totalPrizeAmount).isEqualTo(expectedTotalPrizeAmount);
    }
}
