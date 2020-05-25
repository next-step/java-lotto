package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ResultView {
    private Map<Integer, Integer> lottoRank = new HashMap<>();
    private Map<Integer, Integer> lottoMatchRankCount = new HashMap<>();

    public void printMatchResult(LottoTicket lottoTicket) {
        AtomicInteger totalMatchMoney = new AtomicInteger();
        lottoRank.forEach((rankCount, value) -> {
            int resultCount = lottoMatchRankCount.get(rankCount) == null ? 0 : lottoMatchRankCount.get(rankCount);
            System.out.println(rankCount + "개 일치 (" + value + "원)- " + resultCount + "개");
            if (resultCount != 0) {
                totalMatchMoney.addAndGet(value * resultCount);
            }
        });

        System.out.println("총 수익률은 입니다.");
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


    private void confirmRank(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
            if (lottoRank.containsKey(number)) {
                lottoMatchRankCount.put(number, lottoMatchRankCount.get(number) == null ? 1 : lottoMatchRankCount.get(number) + 1);
            }
        });
    }
}
