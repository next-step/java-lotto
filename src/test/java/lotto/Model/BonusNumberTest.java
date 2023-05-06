package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    @Test
    @DisplayName("BonusNumber 숫자 0 입력 시 return error")
    public void bonusNumber_under_1() {
        String input = "0";

        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("BonusNumber 숫자 46 입력 시 return error")
    public void bonusNumber_above_45() {
        String input = "46";

        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("BonusNumber 숫자 입력 시 정상 할당")
    public void bonusNumber_return_normal() {
        String input = "30";

        int expected = 30;
        int actual = new BonusNumber(input).number();

        assertThat(actual).isEqualTo(expected);
    }

}