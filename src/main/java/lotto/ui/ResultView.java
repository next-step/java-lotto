package lotto.ui;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.rank.LottoRank;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.rank.LottoRankCalculator;
import lotto.domain.rank.LottoRevenueCalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public void printMatchResult(List<LottoRank> lottoRankList) {
        LottoRevenueCalculator lottoRevenueCalculator = new LottoRevenueCalculator(lottoRankList);
        Map<LottoRank, Integer> lottoRankCount = lottoRevenueCalculator.getLottoRankCount();

        System.out.println(LottoRank.FIFTH.getCountOfMatch() + "개 일치 (" + LottoRank.FIFTH.getWinningMoney() + "원)- " + lottoRankCount.get(LottoRank.FIFTH) + "개");
        System.out.println(LottoRank.FOURTH.getCountOfMatch() + "개 일치 (" + LottoRank.FOURTH.getWinningMoney() + "원)- " + lottoRankCount.get(LottoRank.FOURTH) + "개");
        System.out.println(LottoRank.THIRD.getCountOfMatch() + "개 일치 (" + LottoRank.THIRD.getWinningMoney() + "원)- " + lottoRankCount.get(LottoRank.THIRD) + "개");
        System.out.println(LottoRank.SECOND.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + LottoRank.SECOND.getWinningMoney() + "원)- " + lottoRankCount.get(LottoRank.SECOND) + "개");
        System.out.println(LottoRank.FIRST.getCountOfMatch() + "개 일치 (" + LottoRank.FIRST.getWinningMoney() + "원)- " + lottoRankCount.get(LottoRank.FIRST) + "개");
        System.out.println("총 수익률은 " + lottoRevenueCalculator.getRevenueRate() + " 입니다.");
    }

    public void printLottoTicketList(List<LottoTicket> autoLottoTicketList, List<LottoTicket> manualLottoTicketList) {
        System.out.println("수동으로 " + manualLottoTicketList.size() + "장, 자동으로 " + autoLottoTicketList.size() + "개를 구매했습니다.");

        manualLottoTicketList.addAll(autoLottoTicketList);
        manualLottoTicketList.stream()
                .forEach(lottoTicket -> printLottoNumbers(lottoTicket));

        System.out.println();
    }

    private void printLottoNumbers(LottoTicket lottoTicket) {
        List<Integer> collect = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }
}

