package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("String 정답을 ',' 기준으로 List 에 잘 담는지 테스트")
    void splitAnswerNumber() {
        String answerNumbers = "1,2,3,4,5,6";

        assertThat(inputView.splitAnswerNumber(answerNumbers))
                .isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}