package me.namuhuchutong.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import me.namuhuchutong.lotto.domain.Number;
import me.namuhuchutong.lotto.domain.Numbers;
import me.namuhuchutong.lotto.dto.UserInputInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputInformationTest {

    @DisplayName("숫자가 아닌 입력이 존재할 경우 에외가 발생한다.")
    @Test
    void throw_exception_when_receives_non_numeric() {
        //given
        String given = "a, 1, 2, 3, 4";
        int amount = 1;

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(amount, given))
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액은 0 혹은 음수일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void throw_exception_when_receives_zero_or_negative(int amount) {
        //given
        String given = "1, 2, 3, 4, 5, 6";

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(amount, given))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 6개의 숫자를 입력 받아서 Numbers 객체를 반환한다.")
    @Test
    void return_numbers_objects_when_receives_six_numbers_from_user() {
        //given
        String given = "1, 2, 3, 4, 5, 6";
        int amount = 1;
        Numbers expected = new Numbers(
                List.of(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)));

        //when
        UserInputInformation information = new UserInputInformation(amount, given);

        //then
        assertThat(information.getNumbers()).isEqualTo(expected);
    }
}
