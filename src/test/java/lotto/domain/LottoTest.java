package lotto.domain;

import static lotto.exception.ExceptionMessage.ERROR_INVALID_LOTTO_NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Lotto;
import lotto.domain.WinningInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3", "1, 2, 3, 4, 5, 6, 7"})
    @DisplayName("입력한 숫자가 6개가 아닌 경우 Lotto 객체를 생성할 수 없다.")
    void create_withNot6Numbers(String input) {
        assertThatThrownBy(() -> new Lotto(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ERROR_INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("matchWithWinningLotto 메소드는 주어진 로또와 당첨 결과를 맞춰 보고 당첨 정보를 반환한다.")
    void countSameNumbers() {
        Lotto lotto1 = new Lotto("1, 2, 3, 4, 5, 6");
        Lotto lotto2 = new Lotto("1, 2, 3, 7, 8, 9");

        assertThat(lotto1.matchWithWinningLotto(lotto2)).isEqualTo(WinningInformation.FOURTH);
    }
}
