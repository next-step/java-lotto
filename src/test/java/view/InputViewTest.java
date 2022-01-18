package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("정답 개수가 6개 초과일시 Exception 테스트")
    void overInputNumberCount() {
        assertThatThrownBy(() -> inputView.checkInputNumberCount(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(inputView.MESSAGE_INPUT_ANSWER_NUMBER_COUNT_OVER);
    }

    @Test
    @DisplayName("정답 범위가 1~45 벗어나면 Exception 테스트")
    void exceedNumberRange() {
        assertThatThrownBy(() -> inputView.checkNumberRange(new ArrayList<>(Arrays.asList(0, 2, 3, 4, 5, 6, 99))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(inputView.MESSAGE_INPUT_ANSWER_NUMBER_RANGE_OVER);
    }

    @Test
    @DisplayName("String 정답을 ',' 기준으로 List 에 잘 담는지 테스트")
    void splitAnswerNumber() {
        String answerNumbers = "1,2,3,4,5,6";

        assertThat(inputView.splitAnswerNumber(answerNumbers))
                .isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}