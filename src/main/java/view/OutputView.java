package view;

import domain.*;
import domain.Number;

import java.util.List;

public class OutputView {
    public static void printLottoGames(List<Lotto> lottoGameList) {
        for (Lotto lotto : lottoGameList) {
            System.out.println(lotto);
        }
    }

    public static WinningInfos printWinningInfo(LottoGame lottoGame, Lotto lotto, Number bonusNumber) {
        WinningInfos lottoWinningInfos = lottoGame.getWinningInfos(lotto, bonusNumber);
        System.out.println();

        List<WinningInfo> winningInfos = lottoWinningInfos.getWinningInfos();
        winningInfos.forEach(e -> {
            String str = getAdditionalStr(e);
            System.out.printf("%d개 일치%s (%d원) - %d개\n", e.getRank().getCountOfMatch(),
                    str,
                    e.getRank().getWinningMoney().intValue(),
                    e.getWinningNumber());
        });
        return lottoWinningInfos;
    }

    private static String getAdditionalStr(WinningInfo e) {
        if (e.getRank().equals(Rank.SECOND)) return ", 보너스 볼 일치";
        return "";
    }

    public static void printBenefitRate(LottoGame lottoGame, LottoMoney lottoMoney, WinningInfos winningInfos) {
        double benefitRate = lottoGame.getBenefitRate(lottoMoney, winningInfos);
        System.out.println("=========");
        System.out.printf("총 수익률 : %.2f\n", benefitRate);
    }
}
