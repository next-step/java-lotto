package lotto.view;


import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

public class ResultView {
    public static void numberOfLotto(LottoSeller lottoSeller) {
        System.out.println("수동으로 " + lottoSeller.getNumberofManual() + "장, 자동으로 " + lottoSeller.getNumberOfAuto() + "개를 구매했습니다.");
    }

    public static void printLottoList(Lottos lottos) {
        for (int i = 0; i < lottos.getLottoList().size(); i++) {
            System.out.println(lottos.getLottoList().get(i).getLottoNumberList().toString());
        }
    }

    public static void winnerOfLottery(WinningNumbers winningNumbers, Lottos lottos, LottoSeller lottoSeller) {
        winningNumbers.winLotto(lottos.getLottoList());
        System.out.println();
        System.out.println("당첨 통계\n" + "---------");

        for (Rank rank : Rank.values()) {
            System.out.println(winnerMessage(winningNumbers, rank));
        }
        System.out.println("총 수익률은 " + winningNumbers.getRate(lottoSeller.getNumberOfLotto()) + "입니다." +
                "(수익률 1은 복권 가격을 뜻합니다.)");
    }

    private static String winnerMessage(WinningNumbers winningNumbers, Rank rank) {
        if (rank == Rank.SECOND) {
            return rank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원) - " + winningNumbers.getWinnerNumber(rank) + "개";
        }
        return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) - " + winningNumbers.getWinnerNumber(rank) + "개";
    }
}
