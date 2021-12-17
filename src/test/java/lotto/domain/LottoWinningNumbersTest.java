package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningNumbersTest {

    @DisplayName("로또 당첨 번호 문자열을 입력하면 정수 리스트로 변환하여 저장한다.")
    @Test
    void create() {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from("1, 2, 3, 4, 5, 6");
        LottoWinningNumbers lottoWinningNumbersFromList = LottoWinningNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoWinningNumbers).isEqualTo(lottoWinningNumbersFromList);
    }

    @DisplayName("로또 당첨 번호 6개로 LottoWinningNumbers를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints={1, 2, 3, 4, 5, 6})
    void validateNumberOf(int number) {
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.from("1, 2, 3, 4, 5, 6");
        assertThat(lottoWinningNumbers.contain(LottoNumber.from(number))).isEqualTo(true);
    }

    @DisplayName("로또 당첨 번호가 6개가 아니면 LottoException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings={"1, 2, 3, 4, 5, 6, 7", "1, 2, 3, 4, 5"})
    void validateNumberOfThrowException(String numbers) {
        assertThatThrownBy(() -> LottoWinningNumbers.from(numbers))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("중복되는 당첨 번호가 있으면 LottoException이 발생한다.")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> LottoWinningNumbers.from("1, 1, 3, 4, 5, 6"))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining("당첨 번호에는 중복이 있으면 안됩니다");
    }

}