package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 중복될 시 예외를 반환한다.")
    void validate_duplicate() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 시 예외를 반환한다.")
    void validate_size() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 숫자와 로또 번호를 비교해 당첨 개수를 반환한다.")
    void match_user_lotto_and_winning_lotto() {
        Lotto winningLotto = new Lotto(1, 3, 4, 2, 5, 7);

        int count = new Lotto(1, 2, 3, 4, 5, 6).matchCount(winningLotto);

        assertThat(count).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "3:true", "30:false"}, delimiter = ':')
    @DisplayName("로또 번호에 보너스 번호가 포함되어있는지 확인한다.")
    void contains_bonus_number(int number, boolean isContains) {
        LottoNumber bonusNumber = new LottoNumber(number);
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.contains(bonusNumber)).isEqualTo(isContains);
    }
}
