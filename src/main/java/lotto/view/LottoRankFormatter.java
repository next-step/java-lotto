package lotto.view;

import lotto.domain.LottoRank;

public class LottoRankFormatter {

    public static String format(LottoRank rank) {

        String bonusFormat = "";

        if (rank.isRequiresBonusMatch()) {
            bonusFormat = ", 보너스 볼 일치";
        }

        return String.format("%s개 일치%s (%s원)",
                rank.getMatchCount(), bonusFormat, rank.getPrize().getValue());
    }

}
