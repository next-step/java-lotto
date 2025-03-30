package lotto.ui;

import lotto.domain.*;

import java.util.List;

public class ResultView {
    public static void viewLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void viewLottoTickets(LottoGame lottoGame) {
        for (LottoTicket ticket : lottoGame.getTickets().getLottoTickets()) {
            System.out.println("["  + String.join(", ", ticket.getLottoNumbers().stream()
                    .map(String::valueOf)
                    .toArray(String[]::new)) + "]");
        }
        System.out.println();
    }

    public static void viewWinningStatistics(GameResult gameResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.MISS) {
                System.out.printf("%d개 일치 (%d원)- %d개%n",
                        rank.getCountOfMatch(), rank.getWinningMoney(), gameResult.getResultStats().get(rank));
            }
        }

        System.out.printf("총 수익률은 %.2f입니다.%n",
                gameResult.getReturnRate(), gameResult.getReturnRate() < 1 ? "손해" : "이익");

    }

    public static void printListWithCommas(List<Integer> list) {
        // 리스트의 요소를 문자열로 변환 후 ", "로 연결
        System.out.println(String.join(", ", list.stream()
                .map(String::valueOf)
                .toArray(String[]::new)));
    }

}
