package lotto.view;

import lotto.model.LottoSeller;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    public static void numberOfLotto(LottoSeller lottoSeller) {
        System.out.println(lottoSeller.getNumberOfLotto() + "개를 구매했습니다.");
    }

    public static void printLottoList(Lottos lottos) {
        for (int i = 0; i < lottos.getLottoList().size(); i++) {
            System.out.println(lottos.getLottoList().get(i).getLottoNumber().toString());
        }
    }

    public static void winnerOfLottery(WinningNumbers winningNumbers, Lottos lottos, LottoSeller lottoSeller) {
        winningNumbers.winLotto(lottos.getLottoList());
        System.out.println();
        System.out.println("당첨 통계\n" + "---------");
        List<Rank> rankList = rankSet();


        for (Rank rank : rankList) {
            System.out.println(winnerMessage(winningNumbers, rank));
        }
        System.out.println("총 수익률은 " + winningNumbers.getRate(lottoSeller.getNumberOfLotto()) + "입니다." +
                "(수익률 1은 복권 가격을 뜻합니다.)");
    }

    private static List<Rank> rankSet() {
        List<Rank> rankList = new ArrayList<>();
        rankList.add(Rank.FIFTH);
        rankList.add(Rank.FOURTH);
        rankList.add(Rank.THIRD);
        rankList.add(Rank.SECOND);
        rankList.add(Rank.FIRST);

        return rankList;
    }

    private static String winnerMessage(WinningNumbers winningNumbers, Rank rank) {
        if (rank == Rank.SECOND) {
            return rank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원) - " + winningNumbers.getWinnerNumber(rank) + "개";
        }
        return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) - " + winningNumbers.getWinnerNumber(rank) + "개";
    }
}
