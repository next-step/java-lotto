package step2.view;

import step2.model.*;

import java.text.MessageFormat;

public class ResultView {

    private ResultView() {
    }

    public static void printTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getTicketCount() + "장을 구매했습니다.");

        lottoTickets.getLottoTickets().stream()
                .map(LottoTicket::toString)
                .forEach(System.out::println);
    }

    public static void printMatchResult(MatchResult matchResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        matchResult.getWinningResult().forEach((lottoRank, matchCount) -> {
            System.out.println(MessageFormat.format("{0}-{1}개", lottoRank.toString(), matchCount));
        });
    }

//    public static void printWinningStatistics(LottoTickets lottoTickets, List<LottoNumber> winningNumbers) {
//        System.out.println("당첨 통계");
//        System.out.println("---------");
//
//        MatchResult matchResult = lottoTickets.calculateLottoRankCount(winningNumbers);
//        LottoRank.getWinningGroup().forEach(lottoRank -> {
//            int matchCount = matchResult.findCount(lottoRank);
//            System.out.println(lottoRank.getWinningMoney() + "원 - " + matchCount + "개");
//        });
//    }
//
//    public static void printRateOfReturn(LottoTickets lottoTickets, List<LottoNumber> winningNumbers, Money money) {
//        int winningMoney = lottoTickets.calculateWinningMoney(winningNumbers);
//
//        BigDecimal rateOfReturn = BigDecimal.valueOf(winningMoney)
//                .divide(BigDecimal.valueOf(money.getUsedAmount()), 2, RoundingMode.DOWN);
//
//        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
//    }
}
