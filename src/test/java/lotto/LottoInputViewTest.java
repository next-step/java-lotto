package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoInputViewTest {

    @Test
    @DisplayName("지난주 당첨번호 입력 후 유효한 로또 번호인지 확인")
    void winningNumber() {
        assertThat(LottoInputView.validateLottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).isTrue();
    }

    @Test
    @DisplayName("번호 갯수가 6개가 아닌 경우 IllegalArgumentException")
    void 갯수_확인() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    LottoInputView.validateLottoNumbers(Arrays.asList(1, 2, 3, 4, 6));
                }).withMessageMatching("번호 갯수가 6개가 아닙니다.");
    }

}
