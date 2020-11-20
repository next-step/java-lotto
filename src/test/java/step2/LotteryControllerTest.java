package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Maps.newHashMap;
import static step2.view.ResultView.*;

public class LotteryControllerTest {
    private static final List<String> record = new ArrayList<>();

    @DisplayName("컨트롤러는 객체들과 상호작용 순서가 있다")
    @Test
    void interactionSequence() {
        LotteryController lotteryController = new LotteryController(new TestingInputView(), new TestingResultView());

        lotteryController.request();

        verifyInteractionSequence();
    }

    @DisplayName("문자열을 받아 Integer Array 로 변환한다")
    @Test
    void splitAndConvertToIntArray() {
        assertThat(InputView.splitAndConvertToIntArray("1, 2, 3, 4, 5, 6")) //
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("랭킹정보를 문자열로 반환한다.")
    @ParameterizedTest
    @CsvSource(value = { //
            "FIRST|6개 일치 (2000000000원)- 1개", //
            "SECOND|5개 일치, 보너스 볼 일치(30000000원) - 1개", //
            "THIRD|5개 일치 (1500000원)- 1개", //
            "FORTH|4개 일치 (50000원)- 1개", //
            "FIFTH|3개 일치 (5000원)- 1개"}, delimiter = '|')
    void toStringRank(String rankName, String expected) {
        LotteryResult matchResult = new LotteryResult(0, newHashMap(Rank.valueOf(rankName), 1));
        assertThat(ResultView.toStringRank(Rank.valueOf(rankName), matchResult)) //
                .isEqualTo(expected);
    }

    private void verifyInteractionSequence() {
        //@formatter:off
        assertThat(String.join("->", record))
                .isEqualTo("requestMoney->" +
                        "requestManualSelectionCount->" +
                        "requestManualSelectionNumbers->" +
                        "responseTicketCount->" +
                        "responseTickets->" +
                        "requestLastWeekLotteryNumber->" +
                        "requestBonusNumber->" +
                        "responseWinningStat->" +
                        "responseRateOfReturn");
        //@formatter:on
    }

    static class TestingInputView extends InputView {
        public int requestMoney() {
            record.add("requestMoney");
            return 1000;
        }

        protected int requestManualSelectionCount() {
            record.add("requestManualSelectionCount");
            return 0;
        }

        public Set<Set<Integer>> requestManualSelectionNumbers() {
            super.requestManualSelectionNumbers();
            record.add("requestManualSelectionNumbers");
            return Collections.emptySet();
        }

        public Integer[] requestLastWeekLotteryNumber() {
            record.add("requestLastWeekLotteryNumber");
            return new Integer[]{1, 2, 3, 4, 5, 6};
        }

        public Integer requestBonusNumber() {
            record.add("requestBonusNumber");
            return 7;
        }
    }

    static class TestingResultView extends ResultView {
        public void responseTicketCount(TicketAndCount ticketAndCount) {
            record.add("responseTicketCount");
        }

        public void responseTickets(TicketAndCount ticketAndCount) {
            record.add("responseTickets");
        }

        public void responseWinningStat(LotteryResult lotteryResult) {
            record.add("responseWinningStat");
        }

        public void responseRateOfReturn(LotteryResult lotteryResult) {
            record.add("responseRateOfReturn");
        }
    }
}
