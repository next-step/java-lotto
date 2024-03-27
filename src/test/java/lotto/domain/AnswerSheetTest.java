package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnswerSheetTest {


    @Test
    @DisplayName("정답지 숫자데이터의 크기가 6이 아니면 exception 이 던져진다.")
    void answerSheetNumberMustBeSix(){
        assertThatThrownBy(() -> new AnswerSheet(List.of(1),1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}