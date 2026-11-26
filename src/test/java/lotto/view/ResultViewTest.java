package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ResultViewTest {

    @DisplayName("구매한 개수를 알린다")
    @Test
    void toPurchaseMessage() {
        assertThat(ResultView.toPurchaseMessage(14)).isEqualTo("14개를 구매했습니다.");
    }

    @DisplayName("로또 번호를 한 줄로 나타낸다")
    @Test
    void toLottoLine() {
        assertThat(ResultView.toLottoLine(new Lotto(List.of(8, 21, 23, 41, 42, 43))))
                .isEqualTo("[8, 21, 23, 41, 42, 43]");
    }

    @DisplayName("상금별 당첨 횟수를 한 줄로 나타낸다")
    @ParameterizedTest(name = "{0} 이 {1}개")
    @CsvSource({
            "FOURTH, 1, '3개 일치 (5000원)- 1개'",
            "THIRD, 0, '4개 일치 (50000원)- 0개'",
            "SECOND, 0, '5개 일치 (1500000원)- 0개'",
            "FIRST, 0, '6개 일치 (2000000000원)- 0개'"})
    void toPrizeLine(Prize prize, int count, String expected) {
        assertThat(ResultView.toPrizeLine(prize, count)).isEqualTo(expected);
    }

    @DisplayName("수익률이 1 미만이면 손해라고 알린다")
    @Test
    void toProfitRateMessageWhenLoss() {
        assertThat(ResultView.toProfitRateMessage(0.35))
                .isEqualTo("총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }

    @DisplayName("수익률이 1 이상이면 손해 안내를 붙이지 않는다")
    @ParameterizedTest(name = "수익률 {0}")
    @CsvSource({"1.0, '총 수익률은 1.0입니다.'", "2.5, '총 수익률은 2.5입니다.'"})
    void toProfitRateMessageWhenNotLoss(double rate, String expected) {
        assertThat(ResultView.toProfitRateMessage(rate)).isEqualTo(expected);
    }
}
