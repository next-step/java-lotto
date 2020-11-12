package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.LotteryAgentTest.LotteryAgent;
import static step2.LotteryAgentTest.LotteryTickets;
import static step2.LotteryNumberTest.LotteryNumber;
import static step2.LotteryResultTest.LotteryResult;
import static step2.WinningNumberTest.WinningNumber;

public class LotteryControllerTest {
    private static final List<String> record = new ArrayList<>();

    @DisplayName("컨트롤러는 객체들과 상호작용 순서가 있다")
    @Test
    void interactionSequence() {
        LotteryController lotteryController = new LotteryController(new InputView(), new ResultView());

        lotteryController.request();

        verifyInteractionSequence();

    }

    private void verifyInteractionSequence() {
        //@formatter:off
        assertThat(String.join("->", record))
                .isEqualTo("requestMoney->" +
                        "responseTicketCount->" +
                        "responseTickets->" +
                        "requestLastWeekLotteryNumber->" +
                        "responseWinningStat->" +
                        "responseRateOfReturn");
        //@formatter:on
    }

    private static class LotteryController {
        private final InputView inputView;
        private final ResultView resultView;
        private LotteryAgent lotteryAgent;

        public LotteryController(InputView inputView, ResultView resultView) {
            this.inputView = inputView;
            this.resultView = resultView;
            lotteryAgent = new LotteryAgent();
        }

        public void request() {
            Money money = inputView.requestMoney();
            LotteryAgent.ExchangeResult exchangeResult = lotteryAgent.exchange(money);
            resultView.responseTicketCount(exchangeResult.getLotteryTickets());
            resultView.responseTickets(exchangeResult.getLotteryTickets());
            LotteryNumber lastWeekLotteryNumber = inputView.requestLastWeekLotteryNumber();
            LotteryResult lotteryResult = newWinningNumber(lastWeekLotteryNumber).match(exchangeResult.getLotteryTickets());
            resultView.responseWinningStat(lotteryResult);
            resultView.responseRateOfReturn(lotteryResult);
        }

        private WinningNumber newWinningNumber(LotteryNumber lotteryNumber) {
            return new WinningNumber(lotteryNumber);
        }
    }

    static class InputView {
        public Money requestMoney() {
            record.add("requestMoney");
            return Money.of(1000);
        }

        public LotteryNumber requestLastWeekLotteryNumber() {
            record.add("requestLastWeekLotteryNumber");
            return LotteryNumber.of(1, 2, 3, 4, 5, 6);
        }
    }

    static class ResultView {
        public void responseTicketCount(LotteryTickets lotteryTickets) {
            record.add("responseTicketCount");
        }

        public void responseTickets(LotteryTickets lotteryTickets) {
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
