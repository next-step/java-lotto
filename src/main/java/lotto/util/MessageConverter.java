package lotto.util;

import lotto.model.Rank;

public class MessageConverter {

    public static String convertToMatchMessage(Rank rank, int countOfLotto) {
        if (rank == Rank.SECOND) {
            return rank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원)- " + countOfLotto + "개";
        }

        return rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + countOfLotto + "개";
    }
}
