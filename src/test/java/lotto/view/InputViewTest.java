package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    @DisplayName("쉼표로 구분된 당첨 번호를 읽는다")
    @ParameterizedTest(name = "\"{0}\"")
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6", " 1 ,2,  3,4,5 , 6 "})
    void parseNumbers(String input) {
        assertThat(InputView.parseNumbers(input)).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
