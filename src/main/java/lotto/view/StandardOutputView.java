package lotto.view;

import lotto.controller.LottoGames;
import lotto.model.LottoGame;
import lotto.model.PrizeEnum;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StandardOutputView {
    public void printBoughtLotto(LottoGames pages) {
        System.out.println(String.format("%d개를 구입했습니다.", pages.getSize()));
        for (LottoGame page : pages) {
            System.out.println(page.getPageContent());
        }
    }

    public void printSinglePage(int[] pageNumbers) {
        System.out.println(String.format("[%s]", Arrays.stream(pageNumbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")))
        );
    }

    public void printStat(LottoGames pages, int[] winnerPage, int bonusNumber) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (PrizeEnum prize : PrizeEnum.values()) {
            System.out.println(pages.getPrizesContentByEnum(prize, winnerPage, bonusNumber));
            }
        System.out.println(String.format("총 수익률은 %.2f입니다",
                pages.getExpectation(winnerPage, bonusNumber)));
    }
}
