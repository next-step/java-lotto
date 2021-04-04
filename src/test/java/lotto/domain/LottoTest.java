package lotto.domain;

import lotto.constants.Constants;
import lotto.generator.TestLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        assertThatThrownBy(() -> Lotto.from(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5))))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("1등번호와 동일한 번호 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,10,11,12:3", "1,2,3,4,10,11:4", "1,2,3,4,5,7:5",
            "1,2,3,4,5,6:6"}, delimiter = ':')
    void matchCount(String purchaseNumber, int expectedMatchCount) {
        // given
        Lotto prizeLotto = Lotto.from(new TestLottoNumberGenerator());
        Set<Integer> numbers = new HashSet<>(Arrays.asList(purchaseNumber.split(","))).stream()
                .map(i -> Integer.valueOf(i))
                .collect(Collectors.toSet());
        Lotto inputLotto = Lotto.from(numbers);

        // when
        int matchCount = inputLotto.matchCount(prizeLotto);

        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    @Test
    @DisplayName("2등 번호 포함 여부 확인")
    void matchBonus() {
        Lotto lotto = Lotto.from(new TestLottoNumberGenerator());

        assertThat(lotto.matchBonus(Number.from(7))).isFalse();
        assertThat(lotto.matchBonus(Number.from(6))).isTrue();
    }
}
