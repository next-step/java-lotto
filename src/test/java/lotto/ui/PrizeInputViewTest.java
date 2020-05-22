package lotto.ui;

import lotto.domain.lotto.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeInputViewTest {
    @DisplayName("쉼표로 구분된 문자열을 입력 받아서 객체 생성")
    @Test
    void inputTest() {
        PrizeInputView prizeInputView = new PrizeInputView("1, 2, 3, 4, 5, 6", 7);
        assertThat(prizeInputView).isNotNull();
    }

    @DisplayName("null이나 빈 문자열을 입력 받으면 IllegalArgumnetException")
    @Test
    void validateInput() {
        assertThatThrownBy(() -> new PrizeInputView("", 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PrizeInputView("   ", 7))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PrizeInputView(null, 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력받은 문자열을 당첨 티켓으로 변환 가능")
    @Test
    void convertToIntCollectionTest() {
        PrizeInputView prizeInputView = new PrizeInputView("1, 2, 3, 4, 5, 6", 7);
        assertThat(prizeInputView.convertToWinTicket())
                .isEqualTo(LottoGenerator.createManualByIntList(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
