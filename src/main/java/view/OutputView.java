package view;

import domain.*;

import java.util.List;

public class OutputView {
    public static void printLottoGames(List<LottoNumbers> lottoGameList) {
        for (LottoNumbers lottoGame : lottoGameList) {
            System.out.println(lottoGame.getNumbers());
        }
    }

    public static WinningInfos printWinningInfo(LottoGame lottoGame) {
        WinningInfos lottoWinningInfos = lottoGame.getWinningInfos();
        System.out.println();

        List<WinningInfo> winningInfos = lottoWinningInfos.getWinningInfos();
        winningInfos.forEach(e -> System.out.printf("%d개 일치 (%d원) - %d개\n", e.getWinningType().getHitNumber(),
                e.getWinningType().getLottoMoney().getMoney().intValue(),
                e.getWinningNumber()));
        return lottoWinningInfos;
    }

    public static void printBenefitRate(LottoGame lottoGame, LottoMoney lottoMoney, WinningInfos winningInfos) {
        double benefitRate = lottoGame.getBenefitRate(lottoMoney, winningInfos);
        System.out.println("=========");
        System.out.printf("총 수익률 : %.2f\n", benefitRate);
    }
}
