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
        String[] manual = {"9, 1, 2, 3, 4"};
        String given = "a, 1, 2, 3, 4";
        int amount = 1;
        int bonusNumber = 7;

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(amount, manual, given, bonusNumber))
                  .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 금액은 0 혹은 음수일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void throw_exception_when_receives_zero_or_negative(int amount) {
        //given
        String[] manual = {"9, 1, 2, 3, 4"};
        String given = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(amount, manual, given, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자에게 6개의 숫자를 입력 받아서 Numbers 객체를 반환한다.")
    @Test
    void return_numbers_objects_when_receives_six_numbers_from_user() {
        //given
        String[] manual = {"9, 1, 2, 3, 4"};
        String given = "1, 2, 3, 4, 5, 6";
        int amount = 2000;
        int bonusNumber = 7;
        Numbers expected = new Numbers(
                List.of(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)));

        //when
        UserInputInformation information = new UserInputInformation(amount, manual, given, bonusNumber);

        //then
        assertThat(information.getNumbers()).isEqualTo(expected);
    }

    @DisplayName("보너스 번호는 입력된 번호들과 중복되면 안 된다.")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void bonus_number_should_not_be_duplicated_with_existing_numbers(int bonus) {
        //given
        String[] manual = {"9, 1, 2, 3, 4"};
        String given = "1, 2, 3, 4, 5, 6";
        int amount = 1;

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(amount, manual, given, bonus))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("수동 로또는 숫자만 허용한다.")
    @Test
    void throw_exception_when_receives_non_numeric_in_manual_number() {
        //given
        String[] manual = {"a, 1, 2, 3, 4"};
        String lastWinning = "1, 1, 2, 3, 4";
        int amount = 2000;
        int bonusNumber = 7;

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(amount, manual, lastWinning, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또 수는 전체 금액을 초과할 수 없다.")
    @Test
    void throw_exception_when_manual_lotto_exceed_total_amount() {
        //given
        int amount = 1000;
        String[] manual = {"1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6"};
        String lastWinning = "1, 2, 6, 3, 4";
        int bonusNumber = 7;

        //when, then
        assertThatThrownBy(() -> new UserInputInformation(amount, manual, lastWinning, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
