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
import static step2.LotteryResultTest.*;
import static step2.LotteryResultTest.LotteryResult;
import static step2.WinningNumberTest.WinningNumber;

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
    @Test
    void toStringRank() {
        LotteryResult lotteryResult = new LotteryResult();
        lotteryResult.add(3);
        assertThat(ResultView.toStringRank(Rank.FORTH, lotteryResult)) //
                .isEqualTo("3개 일치 (5000원)- 1개");
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

    static class LotteryController {
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
            resultView.responseTicketAndCount(lotteryTickets);

            LotteryNumber lastWeekLotteryNumber = inputView.requestLastWeekLotteryNumber();
            LotteryResult lotteryResult = newWinningNumber(lastWeekLotteryNumber).match(lotteryTickets);
            resultView.responseLotteryResult(lotteryResult);
        }

        private WinningNumber newWinningNumber(LotteryNumber lotteryNumber) {
            return new WinningNumber(lotteryNumber);
        }
    }

    static class InputView {
        public Money requestMoney() {
            System.out.println("구입금액을 입력해 주세요.");
            Scanner scanner = new Scanner(System.in);
            return Money.of(scanner.nextInt());
        }

        public LotteryNumber requestLastWeekLotteryNumber() {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
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
        public void responseTicketAndCount(LotteryTickets lotteryTickets) {
            responseTicketCount(lotteryTickets);
            responseTickets(lotteryTickets);
        }

        public void responseTicketCount(LotteryTickets lotteryTickets) {
            System.out.printf("%d개를 구매했습니다.%n", lotteryTickets.size());
        }

        public void responseTickets(LotteryTickets lotteryTickets) {
            lotteryTickets.getNumbers().forEach(System.out::println);
            System.out.println();
        }

        public void responseLotteryResult(LotteryResult lotteryResult) {
            responseWinningStat(lotteryResult);
            responseRateOfReturn(lotteryResult);
        }

        public void responseWinningStat(LotteryResult lotteryResult) {
            //@formatter:off
            System.out.println(
                    "\n당첨 통계\n" +
                    "---------");
            //@formatter:on
            System.out.println(toStringRank(Rank.FORTH, lotteryResult));
            System.out.println(toStringRank(Rank.THIRD, lotteryResult));
            System.out.println(toStringRank(Rank.SECOND, lotteryResult));
            System.out.println(toStringRank(Rank.FIRST, lotteryResult));
            System.out.println(toStringRank(Rank.FIRST, lotteryResult));
        }

        public static String toStringRank(Rank rank, LotteryResult lotteryResult) {
            return String.format("%d개 일치 (%d원)- %d개", //
                    rank.getMatchingCount(),  //
                    rank.getPrizeAmount().toInt(), //
                    lotteryResult.getMatchResult(rank));
        }

        public void responseRateOfReturn(LotteryResult lotteryResult) {
            System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", lotteryResult.getRateOfReturn());
        }
    }

    static class TestingResultView extends ResultView {
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
