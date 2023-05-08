package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class WinningLottoTest {

    @Test
    @DisplayName("입력 값이 중복될 경우 InvalidParameterException을 던진다")
    void checkInput_테스트() {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> {
                    new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(6));
                }).withMessageMatching("bonusNumber와 winningLotto 숫자는 중복될 수 없습니다.");
    }

}
