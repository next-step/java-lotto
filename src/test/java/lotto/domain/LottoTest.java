package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {

    private final Lotto baseLotto = new Lotto("1, 2, 3, 4, 5, 6");

    @DisplayName("문자열숫자 6개로 로또를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 45"})
    void create_string(String lottoNumbers) {
        assertDoesNotThrow(() -> Lotto.pickManualNumber(lottoNumbers));
    }

    @DisplayName("자동으로 로또 생성가능한지 확인")
    @Test
    void create_auto() {
        assertDoesNotThrow(() -> Lotto.pickAutoNumber());
    }

    @DisplayName("수동 중복 번호 불가")
    @Test
    void create_string_duplicate() {
        assertThatThrownBy(() -> Lotto.pickManualNumber("1, 1, 1, 1, 1, 1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
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
                .isInstanceOf(NumberFormatException.class);
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
        Lotto winLotto = baseLotto;

        assertThat(lotto.countMatch(winLotto)).isEqualTo(matchCount);
    }

    @DisplayName("로또가 보너스 번호를 포함하고 있는지 확인")
    @Test
    void contains() {
        Lotto lotto = baseLotto;
        LottoNumber bonus = LottoNumber.valueOf(6);

        assertThat(lotto.contains(bonus)).isTrue();
    }

    @DisplayName("로또가 보너스 번호를 포함하고 있는지 확인_실패")
    @Test
    void contains_fail() {
        Lotto lotto = baseLotto;
        LottoNumber bonus = LottoNumber.valueOf(7);

        assertThat(lotto.contains(bonus)).isFalse();
    }

}
