package view;

import domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    InputView inputView = new InputView();

    @Test
    @DisplayName("String 정답을 ',' 기준으로 LottoNumber 객체로 잘 담는지 테스트")
    void splitAnswerNumber() {
        String answerNumbers = "1,2,3,4,5,6";

        assertThat(inputView.splitAnswerNumber(answerNumbers))
                .contains(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
    }
}