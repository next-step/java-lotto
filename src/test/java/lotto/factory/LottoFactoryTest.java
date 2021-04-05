package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    @Test
    @DisplayName("수동 구매시 동일한 번호와 함께 로또 1개가 반환된다.")
    void buyManualLottos() {
        // given
        List<Set<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(inputLottoNumber("1,2,3,4,5,6"));
        Money money = Money.from(1000);

        // when
        List<Lotto> lottos = LottoFactory.buyManualLottos(manualLottoNumbers, money);

        // then
        assertThat(lottos.size()).isEqualTo(1);
        assertThat(lottos.get(0)).isEqualTo(Lotto.from(new TestLottoNumberGenerator()));
    }

    private static Set<Integer> inputLottoNumber(String lottoNumberString) {
        String[] lottoNumbers = lottoNumberString.split(",");
        return Arrays.stream(lottoNumbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toSet());
    }

    @DisplayName("입력한 구매금액 천원당 로또 번호 1개씩 반환된다.")
    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "5000,5"})
    void buyAutoLottos(int amount, int expectedCount) {
        // given
        Money money = Money.from(amount);

        // when
        List<Lotto> lottos = LottoFactory.buyAutoLottos(new TestLottoNumberGenerator(), money);

        // then
        assertThat(lottos.size()).isEqualTo(expectedCount);
    }
}