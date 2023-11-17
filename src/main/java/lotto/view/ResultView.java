package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;

public class ResultView {
    private static int MINIMUM_RANK=3;
    private static int MAXIMUM_RANK=6;
    public static void numberOfLotto(LottoSeller lottoSeller) {
        System.out.println(lottoSeller.getNumberOfLotto() + "개를 구매했습니다.");
    }

    public static void printLottoList(Lottos lottos) {
        for (int i=0; i < lottos.getLottoList().size(); i++) {
            System.out.println(lottos.getLottoList().get(i).getLottoNumber().toString());
        }
    }

    public static void winnerOfLottery(WinningNumbers winningNumbers, Lottos lottos, LottoSeller lottoSeller) {
        winningNumbers.winLotto(lottos.getLottoList());
        System.out.println();
        System.out.println("당첨 통계\n" + "---------");

        for (int i=MINIMUM_RANK; i<=MAXIMUM_RANK; i++) {
            System.out.println(i + "개 일치 (" + winningNumbers.getWinnerPrice(i) + "원) - " + winningNumbers.getWinnerNumber(i) + "개");
        }
        System.out.println("총 수익률은 "+ winningNumbers.getRate(lottoSeller.getNumberOfLotto()) + "입니다." +
                "(수익률 1은 복권 가격을 뜻합니다.)");
    }
}
