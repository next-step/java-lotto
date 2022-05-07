package study.step2.view;

import study.step2.domain.*;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String EXCEPTION_INFORMATION_MESSAGE = "로또 구입 금액을 올바르게 입력해주세요.";
    private static final String RESULT_INFORMATION_MESSAGE = "개를 구매했습니다.";
    private static final String NUMBER_REGULAR_EXPRESSION = "^([1-9]\\d*)$";
    private static final String RESULT_WINNER_RANK = "당첨 통계";
    private static final String RESULT_WINNER_LINE = "----------";

    private ResultView() {}

    public static int printTicketCount(int price) {
        if (isInvalid(price)) {
            throw new IllegalArgumentException(EXCEPTION_INFORMATION_MESSAGE);
        }
        int result = LottoTicketCount.calculateTicketCount(price);
        System.out.println(result + RESULT_INFORMATION_MESSAGE);
        return result;
    }

    private static boolean isInvalid(int price) {
        if (!String.valueOf(price).matches(NUMBER_REGULAR_EXPRESSION)) {
            return true;
        }
        if (price % ONE_LOTTO_PRICE != 0) {
            return true;
        }
        return false;
    }

    public static void printLottoTickets(LottoTickets tickets) {
        tickets.getTickets().forEach(element -> System.out.println(element.getTicket()));
    }

    public static void printLottoRanksInfos(List<LottoTicket> lottoTickets, LottoWinningNumber winningNumber) {
        System.out.println(RESULT_WINNER_RANK);
        System.out.println(RESULT_WINNER_LINE);

        Arrays.asList(LottoRank.values())
                .stream()
                .forEach(lottoRank -> printLottoRank(lottoRank, lottoTickets, winningNumber));
    }

    public static void printLottoAnalysis(LottoAnalysis lottoAnalysis) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottoAnalysis.analyze()) + "입니다.(기준이 1이기 때문에 결과적으로 " + lottoAnalysis.stringAnalysis() + "라는 의미임)");
    }

    public static void printLottoRank(LottoRank lottoRank, List<LottoTicket> lottoTickets, LottoWinningNumber winningNumber) {
        if (lottoRank.matchCount != 0) {
            System.out.println(lottoRank.matchCount + "개 일치 (" + lottoRank.prize + ") - " + lottoRank.winnerCount(lottoTickets, winningNumber) + "개");
        }
    }
}
