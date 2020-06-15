package lotto.view;

import lotto.controller.LottoGames;
import lotto.model.LottoLine;
import lotto.model.LottoResult;
import lotto.model.PrizeEnum;

public class StandardOutputView {
    public void printBoughtLotto(int manualSize, LottoGames games) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구입했습니다.\n", manualSize, games.getSize());
        for (LottoLine line : games) {
            System.out.println(line.getLineContent());
        }
    }

    public void printSinglePage(int[] pageNumbers) {
        System.out.println(new LottoLine(pageNumbers).getLineContent());
    }

    public void printStat(LottoGames games, LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        for (PrizeEnum prize : PrizeEnum.values()) {
            System.out.print(games.getPrizesContentByEnum(prize, result));
        }
        System.out.printf("총 수익률은 %.2f입니다",
                games.getExpectation(result));
    }
}
