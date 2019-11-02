package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserInputTest {

    @Test
    @DisplayName("쉼표와 콜론으로 문자열 파싱한다.")
    void parsingStrings() {
        //given
        UserInput userInput = new UserInput("1,2:3");

        //when
        List<Integer> integers = userInput.getIntegers();

        //then
        assertThat(integers).hasSize(3);
        assertThat(integers).containsExactly(1, 2, 3);

    }

    @Test
    @DisplayName("사용자정의 구분자를 받아 파싱한다.")
    void parsingStringWithCustomDelimit() {
        //given
        UserInput userInput = new UserInput("//;\\n1;2;3");

        //when
        List<Integer> integers = userInput.getIntegers();

        //then
        assertThat(integers).hasSize(3);
        assertThat(integers).containsExactly(1, 2, 3);
    }
}
