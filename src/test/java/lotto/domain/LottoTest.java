package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("문자열숫자 6개로 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 45"})
    void create_string(String lottoNumbers) {
        Assertions.assertDoesNotThrow(() -> new Lotto(lottoNumbers));
    }

    @DisplayName("문자열숫자 6개로 로또를 생성한다.(범위 이외의 숫자_실패)")
    @ParameterizedTest
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "46, 1, 2, 3, 4, 5"})
    void create_string_out_of_bound_number_fail(String lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 로또번호는 없습니다.");
    }

    @DisplayName("문자열숫자 6개로 로또를 생성한다.(숫자가 아님_실패)")
    @ParameterizedTest
    @ValueSource(strings = {"a, 1, 2, 3, 4, 5"})
    void create_string_non_number_fail(String lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(NumberFormatException.class); // 문자열을 숫자로 바꾸는데 NumberFormatExeception같은 경우. 따로 체크를 해줘야하는지?
    }

    @DisplayName("당첨 번호와 비교해 일치하는 개수")
    @ParameterizedTest
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6|6",
            "1, 2, 3, 4, 5, 7|5",
            "1, 2, 3, 4, 7, 8|4",
            "1, 2, 3, 7, 8, 9|3"},
            delimiter = '|')
    void countMatch(String lottoNumbers, int matchCount) {
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto winLotto = new Lotto("1, 2, 3, 4, 5, 6");

        assertThat(lotto.countMatch(winLotto)).isEqualTo(matchCount);
    }

}
