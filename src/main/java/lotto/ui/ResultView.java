package lotto.ui;

import lotto.domain.LottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ResultView {
    private final static int LOTTO_PRICE = 1000;

    private List<LottoTicket> lottoTicketList;
    private Map<Integer, Integer> lottoRank = new HashMap<>();
    private Map<Integer, Integer> lottoMatchRankCount = new HashMap<>();

    public ResultView(List<LottoTicket> lottoTicketList) {
        initLottoRank();
        this.lottoTicketList = lottoTicketList;
    }

    public void printLottoTicketList() {
        System.out.println(lottoTicketList.size() + "개를 구매했습니다.");

        lottoTicketList.stream()
                .forEach(lottoTicket -> lottoTicket.printLottoNumbers());

        System.out.println();
    }

    public void printMatchResult(String winningNumber) {
        List<Integer> numbers = convertList(winningNumber);
        confirmRank(numbers);

        AtomicInteger totalMatchMoney = new AtomicInteger();
        lottoRank.forEach((rankCount, value) -> {
            int resultCount = lottoMatchRankCount.get(rankCount) == null ? 0 : lottoMatchRankCount.get(rankCount);
            System.out.println(rankCount + "개 일치 (" + value + "원)- " + resultCount + "개");
            if (resultCount != 0) {
                totalMatchMoney.addAndGet(value * resultCount);
            }
        });

        Double revenueRate = Double.valueOf(totalMatchMoney.get()) / Double.valueOf(lottoTicketList.size() * LOTTO_PRICE);
        System.out.println("총 수익률은 " + String.format("%.2f", revenueRate) + "입니다.");
    }

    private void confirmRank(List<Integer> numbers) {
        numbers.stream().forEach(number -> {
            if (lottoRank.containsKey(number)) {
                lottoMatchRankCount.put(number, lottoMatchRankCount.get(number) == null ? 1 : lottoMatchRankCount.get(number) + 1);
            }
        });
    }

    private List<Integer> convertList(String winningNumber) {
        return lottoTicketList.stream()
                .map(lottoTicket -> lottoTicket.matchWinningNumbers(winningNumber))
                .collect(Collectors.toList());
    }

    private void initLottoRank() {
        int[] lottoRankNumber = {3, 4, 5, 6};
        int[] lottoRankMoney = {5000, 50000, 1500000, 2000000000};

        for (int i = 0; i < lottoRankMoney.length; i++) {
            lottoRank.put(lottoRankNumber[i], lottoRankMoney[i]);
        }
    }
}
