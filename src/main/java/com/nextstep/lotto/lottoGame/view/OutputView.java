package com.nextstep.lotto.lottoGame.view;

import com.nextstep.lotto.lottoGame.domain.LottoResult;
import com.nextstep.lotto.lottoGame.domain.LottoTicket;
import com.nextstep.lotto.lottoGame.domain.Rank;

import java.util.List;

public class OutputView {

    public static void drawPublishResult(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + " 개를 생성했습니다.");
        for (LottoTicket ticket : tickets) {
            List<Integer> lottoNumbers = ticket.getLottoNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public static void drawResult(LottoResult lottoResult, final int usedBudget) {
        System.out.println();
        System.out.println("당첨통계");
        System.out.println("--------");
        if (lottoResult.contains(Rank.FIRST)) {
            System.out.printf("1등 : %s 개%n", lottoResult.getCount(Rank.FIRST));
        }
        if (lottoResult.contains(Rank.SECOND)) {
            System.out.printf("2등 : %s 개%n", lottoResult.getCount(Rank.SECOND));
        }
        if (lottoResult.contains(Rank.THIRD)) {
            System.out.printf("3등 : %s 개%n", lottoResult.getCount(Rank.THIRD));
        }
        if (lottoResult.contains(Rank.FOURTH)) {
            System.out.printf("4등 : %s 개%n", lottoResult.getCount(Rank.FOURTH));
        }
        int prizeSum = lottoResult.getPrizeSum();
        System.out.println("총 상금 : " + prizeSum);
        System.out.println("수익율 : " + ((double) prizeSum / usedBudget));
    }
}
