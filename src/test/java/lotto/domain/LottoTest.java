package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import lotto.constants.Constants;
import lotto.generator.TestLottoNumberGenerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("번호가 6개인 로또가 생성된다")
    void from() {
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        assertThat(lotto.getNumbers().size()).isEqualTo(Constants.LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또를 6개 번호로 생성하지 않으면 RuntimeException 발생한다")
    void from_isNotLottoSize() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5))
                .stream()
                .collect(Collectors.toSet());

        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("구매한 번호로 당첨 금액을 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,10,11,12:13:5000", "1,2,3,4,10,11:12:50000", "1,2,3,4,5,7:8:1500000",
            "1,2,3,4,5,7:6:30000000", "1,2,3,4,5,6:7:2000000000"}, delimiter = ':')
    void getRank(String purchaseNumber, int bonusNum, int expectedAmount) {
        // given
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());
        Set<Integer> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(",")))
                .stream()
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());
        Lotto prizeLotto = Lotto.from(numbers);
        Number bonusNumber = Number.from(bonusNum);

        // when
        Rank rank = lotto.getRank(prizeLotto, bonusNumber);

        // then
        assertThat(rank.getAmount()).isEqualTo(expectedAmount);
    }
}
