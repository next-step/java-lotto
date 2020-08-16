package view;

import domain.*;

import java.util.List;

public class OutputView {
    public static void printLottoGames(List<LottoNumbers> lottoGameList) {
        for (LottoNumbers lottoNumbers : lottoGameList) {
            System.out.println(lottoNumbers);
        }
    }

    public static WinningInfos printWinningInfo(LottoGame lottoGame, LottoNumbers lottoNumbers) {
        WinningInfos lottoWinningInfos = lottoGame.getWinningInfos(lottoNumbers);
        System.out.println();

        List<WinningInfo> winningInfos = lottoWinningInfos.getWinningInfos();
        winningInfos.forEach(e -> System.out.printf("%d개 일치 (%d원) - %d개\n", e.getRank().getCountOfMatch(),
                e.getRank().getWinningMoney().intValue(),
                e.getWinningNumber()));
        return lottoWinningInfos;
    }

    public static void printBenefitRate(LottoGame lottoGame, LottoMoney lottoMoney, WinningInfos winningInfos) {
        double benefitRate = lottoGame.getBenefitRate(lottoMoney, winningInfos);
        System.out.println("=========");
        System.out.printf("총 수익률 : %.2f\n", benefitRate);
    }
}
