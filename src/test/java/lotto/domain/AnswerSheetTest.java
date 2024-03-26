package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AnswerSheetTest {


    @Test
    @DisplayName("정답지 숫자데이터의 크기가 6이 아니면 exception 이 발생한다.")
    void answerSheetNumberMustBeSix(){
        assertThatThrownBy(() -> new AnswerSheet(List.of(1),1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lotto를 넘겨주면 맞는 개수를 반환해준다.")
    void matchCount() {
        AnswerSheet answerSheet = new AnswerSheet(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 5, 6, 7));
        assertThat(answerSheet.matchCount(lotto)).isEqualTo(5);
    }

    @Test
    @DisplayName("lotto를 넘겨주면 보너스의 유무를 알려준다.")
    void matchBonus() {
        AnswerSheet answerSheet = new AnswerSheet(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 5, 6, 7));
        assertThat(answerSheet.matchBonus(lotto)).isEqualTo(true);
    }
}