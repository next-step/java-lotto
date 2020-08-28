package view;

import domain.*;

import java.util.List;

public class OutputView {
    public static void printLottoGames(LottoGame lottoGame) {
        System.out.println(lottoGame);
    }

    public static void printResult(int money, WinningInfos winningInfos) {
        winningInfos.getWinningInfos().forEach(winningInfo -> {
            String str = getAdditionalStr(winningInfo);
            System.out.printf("%d개 일치%s (%d원) - %d개\n", winningInfo.getRank().getCountOfMatch(),
                    str,
                    winningInfo.getRank().getWinningMoney().intValue(),
                    winningInfo.getWinningNumber());
        });
        printBenefitRate(new LottoMoney(money), winningInfos);
    }

    private static String getAdditionalStr(WinningInfo winningInfo) {
        if (winningInfo.getRank().equals(Rank.SECOND)) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    public static void printBenefitRate(LottoMoney lottoMoney, WinningInfos winningInfos) {
        double benefitRate = winningInfos.getBenefitRate(lottoMoney);
        System.out.println("=========");
        System.out.printf("총 수익률 : %.2f\n", benefitRate);
    }
}
