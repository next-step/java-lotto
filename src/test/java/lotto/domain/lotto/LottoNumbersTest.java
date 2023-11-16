package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @Test
    @DisplayName("로또를 생성한다. 로또 번호는 1 ~ 45사이의 숫자이어여 하고 총 6자리 이어야 한다. 아니면 예외가 발생한다.")
    void create() {
        assertThatThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumbers.of(Arrays.asList(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "번호를 비교하여 중복되는 번호의 수를 리턴한다")
    @MethodSource("generateData")
    void match(int excepted, List<Integer> list) {
        LottoNumbers jackpot = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = LottoNumbers.of(list);
        assertThat(jackpot.match(lottoNumbers)).isEqualTo(excepted);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(6, Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(5, Arrays.asList(1, 2, 3, 4, 5, 45)),
                Arguments.of(4, Arrays.asList(1, 2, 3, 4, 44, 45)),
                Arguments.of(3, Arrays.asList(1, 2, 3, 43, 44, 45)),
                Arguments.of(2, Arrays.asList(1, 2, 42, 43, 44, 45)),
                Arguments.of(1, Arrays.asList(1, 41, 42, 43, 44, 45)),
                Arguments.of(0, Arrays.asList(40, 41, 42, 43, 44, 45)));
    }

    @Test
    @DisplayName("현재 로또에 2등 번호의 존재 여부를 리턴한다")
    void bonusmatch() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).bonusMatch(LottoNumber.of(1))).isTrue();
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6).bonusMatch(LottoNumber.of(45))).isFalse();
    }

}
