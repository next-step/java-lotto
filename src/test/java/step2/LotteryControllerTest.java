package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        LotteryController lotteryController = new LotteryController(new TestingInputView(), new ResultView());

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
            LotteryTickets lotteryTickets = lotteryAgent.exchange(money).getLotteryTickets();
            resultView.responseTickets(lotteryTickets);

            LotteryNumber lastWeekLotteryNumber = inputView.requestLastWeekLotteryNumber();
            LotteryResult lotteryResult = newWinningNumber(lastWeekLotteryNumber).match(lotteryTickets);
            resultView.responseWinningStat(lotteryResult);
        }

        private WinningNumber newWinningNumber(LotteryNumber lotteryNumber) {
            return new WinningNumber(lotteryNumber);
        }
    }

    static class InputView {
        public Money requestMoney() {
            Scanner scanner = new Scanner(System.in);
            return Money.of(scanner.nextInt());
        }

        public LotteryNumber requestLastWeekLotteryNumber() {
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            Integer[] lastWeekLotteryNumber = splitAndConvertToIntArray(line);
            return LotteryNumber.of(lastWeekLotteryNumber);
        }

        public static Integer[] splitAndConvertToIntArray(String line) {
            return Arrays.stream(line.split(",")) //
                    .map(String::trim) //
                    .map(Integer::valueOf) //
                    .toArray(Integer[]::new);
        }
    }

    static class TestingInputView extends InputView {
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
            responseTicketCount(lotteryTickets);
            record.add("responseTickets");
        }

        public void responseWinningStat(LotteryResult lotteryResult) {
            record.add("responseWinningStat");
            responseRateOfReturn(lotteryResult);
        }

        public void responseRateOfReturn(LotteryResult lotteryResult) {
            record.add("responseRateOfReturn");
        }
    }
}
