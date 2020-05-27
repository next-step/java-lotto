package lotto.ui;

import lotto.domain.lotto.LottoRevenueCalculator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.rank.LottoRank;
import lotto.domain.lotto.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResultView {
    private static final int LOTTO_MATCH_MAX_SIZE = 6;
    private static final int LOTTO_MATCH_MIN_SIZE = 3;

    private Map<Integer, Integer> lottoRankCount = new HashMap<>();

    public void printMatchResult(List<Integer> lottoRankList) {
        int winningMoney = getWinningMoneyAndCounting(lottoRankList);

        lottoRankCount.forEach((rank, count) -> {
            System.out.println(rank + "개 일치 (" + LottoRank.valueOf(rank).get().getWinningMoney() + "원)- " + count + "개");
        });

        String rate = LottoRevenueCalculator.revenueCalculate(lottoRankList.size() * 1000, winningMoney);
        System.out.println("총 수익률은 " + rate + "입니다.");
    }

    private int getWinningMoneyAndCounting(List<Integer> lottoRankList) {
        int winningMoney = 0;
        initLottoRankCount();
        for (int lottoRankNumber : lottoRankList) {
            if (lottoRankNumber < 3) continue;
            Optional<LottoRank> lottoRank = LottoRank.valueOf(lottoRankNumber);
            LottoRank rank = lottoRank.get();

            saveRankCount(rank);
            winningMoney += rank.getWinningMoney();
        }
        return winningMoney;
    }

    public void printLottoTicketList(List<LottoTicket> lottoTicketList) {
        System.out.println(lottoTicketList.size() + "개를 구매했습니다.");

        lottoTicketList.stream()
                .forEach(lottoTicket -> printLottoNumbers(lottoTicket));

        System.out.println();
    }

    private void saveRankCount(LottoRank rank) {
        lottoRankCount.put(rank.getCountOfMatch(), lottoRankCount.get(rank.getCountOfMatch()) + 1);
    }

    private void initLottoRankCount() {
        for (int i = LOTTO_MATCH_MIN_SIZE; i <= LOTTO_MATCH_MAX_SIZE; i++) {
            lottoRankCount.put(i, 0);
        }
    }

    private void printLottoNumbers(LottoTicket lottoTicket) {
        List<Integer> collect = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }
}

