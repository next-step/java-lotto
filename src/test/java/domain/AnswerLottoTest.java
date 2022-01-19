package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class AnswerLottoTest {

    @Test
    @DisplayName("정답 개수가 6개 초과일시 Exception 테스트")
    void checkInputNumberCount() {
        assertThatThrownBy(() -> new AnswerLotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AnswerLotto.MESSAGE_INPUT_ANSWER_NUMBER_COUNT_OVER);
    }

    @Test
    @DisplayName("정답 범위가 1~45 벗어나면 Exception 테스트")
    void checkNumberRange() {
        assertThatThrownBy(() -> new AnswerLotto(new ArrayList<>(Arrays.asList(0, 2, 3, 4, 5, 99))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(AnswerLotto.MESSAGE_INPUT_ANSWER_NUMBER_RANGE_OVER);
    }
}