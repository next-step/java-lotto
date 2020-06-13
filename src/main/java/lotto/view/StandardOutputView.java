package lotto.view;

import lotto.controller.LottoPages;
import lotto.model.LottoSinglePage;
import lotto.model.WinnerEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StandardOutputView {
    public void printBoughtLotto(LottoPages pages) {
        System.out.println(String.format("%d개를 구입했습니다.", pages.getSize()));
        for (LottoSinglePage page : pages) {
            page.printPages(this);
        }
    }

    public void printSinglePage(int[] pageNumbers) {
        System.out.println(String.format("[%s]", Arrays.stream(pageNumbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")))
        );
    }

    public void printStat(LottoPages pages, int[] winnerPage) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (WinnerEnum winner : WinnerEnum.values()) {
            if (winner == WinnerEnum.FAIL) continue;
            System.out.println(String.format("%d개 일치 (%d)- %d개", winner.getMatch(), winner.getPrize(),
                    pages.getPrizesByEnum(winner, winnerPage)));
        }
        System.out.println(String.format("총 수익률은 %.2f입니다", pages.getExpectation(winnerPage)));
    }
}
