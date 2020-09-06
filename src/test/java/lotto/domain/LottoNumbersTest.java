package lotto.domain;

import lotto.domain.LottoNumbers;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @Test
    @DisplayName("숫자가 1 ~ 45 사이인 경우")
    void create() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6)).isNotNull();
        assertThat(LottoNumbers.of(40, 41, 42, 43, 44, 45)).isNotNull();
    }

    @Test
    @DisplayName("숫자가 1 ~ 45 사이가 아닌 경우")
    void create_outOfRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(0, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(-1, 2, 3, 4, 5, 6));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(41, 42, 43, 44, 45, 46));
    }

    @Test
    @DisplayName("숫자가 6개인 경우")
    void create_size() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6)).isNotNull();
        assertThat(LottoNumbers.of(40, 41, 42, 43, 44, 45)).isNotNull();
    }

    @Test
    @DisplayName("숫자가 6개가 아닌 경우")
    void create_sizeNot6() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    @DisplayName("숫자가 중복된 경우")
    void create_duplicated() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(1, 1, 2, 3, 4, 5));
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    @DisplayName("일치하는 숫자 개수 확인")
    void drawing(LottoNumbers myNumbers, Prize prize) {
        LottoNumbers winningNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);
        assertThat(myNumbers.matchNumbers(winningNumbers)).isEqualTo(prize);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(LottoNumbers.of(7, 8, 9, 10, 11, 12), Prize.ETC),
                Arguments.of(LottoNumbers.of(1, 8, 9, 10, 11, 12), Prize.ETC),
                Arguments.of(LottoNumbers.of(1, 2, 9, 10, 11, 12), Prize.ETC),
                Arguments.of(LottoNumbers.of(1, 2, 3, 7, 8, 9), Prize.FOURTH),
                Arguments.of(LottoNumbers.of(1, 2, 3, 4, 8, 9), Prize.THIRD),
                Arguments.of(LottoNumbers.of(1, 2, 3, 4, 5, 9), Prize.SECOND),
                Arguments.of(LottoNumbers.of(1, 2, 3, 4, 5, 6), Prize.FIRST)
        );
    }
}
