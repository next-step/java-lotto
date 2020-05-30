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

        lottoRankCount.forEach((lottoRank, count) -> {
            System.out.println(lottoRank.getCountOfMatch() + "개 일치 (" + lottoRank.getWinningMoney() + ")- " + count + "개");
        });

        System.out.println("총 수익률은 " + lottoRevenueCalculator.getRevenueRate() + " 입니다.");
    }

    public void printLottoTicketList(List<LottoTicket> lottoTicketList) {
        System.out.println(lottoTicketList.size() + "개를 구매했습니다.");

        lottoTicketList.stream()
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

