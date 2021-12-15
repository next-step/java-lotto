package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.MatchCriteria;
import lotto.domain.NumberGroup;
import lotto.domain.Rate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printLottoCount(int lottoPieceCount) {
        System.out.println(lottoPieceCount + "개를 구매했습니다.");
    }

    public void printLotto(Lotto lotto) {
        for (NumberGroup numberGroup : lotto.getNumberGroups()) {
            System.out.println(numberGroup.toString());
        }
    }

    public void printMatchingStatistics(List<MatchCriteria> matchCriterias, Rate rate) {
        System.out.println("당첨 통계\n" +
                "---------");
        for (MatchCriteria value : matchCriterias) {
            System.out.println(value.getCriteria() + "개 일치 (" + value.getPrize() + "원)- " + value.getCount() + "개");
        }
        System.out.println("총 수익률은 " + rate.getValue() + "입니다.");
    }

}
