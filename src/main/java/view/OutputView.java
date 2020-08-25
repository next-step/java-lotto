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

    public static WinningInfos printWinningInfo(LottoGame lottoGame, WinningLotto lotto) {
        WinningInfos lottoWinningInfos = lottoGame.getWinningInfos(lotto);
        System.out.println();

        List<WinningInfo> winningInfos = lottoWinningInfos.getWinningInfos();
        winningInfos.forEach(winningInfo -> {
            String str = getAdditionalStr(winningInfo);
            System.out.printf("%d개 일치%s (%d원) - %d개\n", winningInfo.getRank().getCountOfMatch(),
                    str,
                    winningInfo.getRank().getWinningMoney().intValue(),
                    winningInfo.getWinningNumber());
        });
        return lottoWinningInfos;
    }

    private static String getAdditionalStr(WinningInfo winningInfo) {
        if (winningInfo.getRank().equals(Rank.SECOND)) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public static void printBenefitRate(LottoGame lottoGame, LottoMoney lottoMoney, WinningInfos winningInfos) {
        double benefitRate = winningInfos.getBenefitRate(lottoMoney);
        System.out.println("=========");
        System.out.printf("총 수익률 : %.2f\n", benefitRate);
    }
}
