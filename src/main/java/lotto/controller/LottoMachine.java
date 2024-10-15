package lotto.controller;

import lotto.entity.Lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.entity.LottoNumber;
import lotto.entity.Lottos;
import lotto.entity.PrizePolicy;

public class LottoMachine {
    public static final int MIN_MATCH_COUNT = 3;
    private Lottos totalLottoTicket;

    public LottoMachine() {
        totalLottoTicket = new Lottos(new ArrayList<>());
    }

    public Lotto makeLottoTicket() {
        return new Lotto();
    }

    public Lottos makeTotalLottoTickets(int totalTicketCount) {
        List<Lotto> lottoList = IntStream.range(0, totalTicketCount)
                .mapToObj(i -> makeLottoTicket())
                .collect(Collectors.toList());
        totalLottoTicket = new Lottos(lottoList);
        return totalLottoTicket;
    }

    public List<Integer> checkMatchingNumber(List<LottoNumber> inputWinningNumbers) {
        Lotto winningLotto = new Lotto(inputWinningNumbers);

        List<Integer> matchingLottoTickets = totalLottoTicket.getValues().stream()
                .map(lottoTicket -> lottoTicket.matchCount(winningLotto))
                .collect(Collectors.toList());

        Collections.sort(matchingLottoTickets);
        return matchingLottoTickets;
    }

    public Map<PrizePolicy, Integer> winningResult(List<Integer> matchingLottoTickets) {
        Map<PrizePolicy, Integer> winLottoTicket = new HashMap<>();
        for (Integer matchCount : matchingLottoTickets) {
            inputWinLottoTicket(winLottoTicket, matchCount);
        }
        return winLottoTicket;
    }

    private static void inputWinLottoTicket(Map<PrizePolicy, Integer> winLottoTicket, Integer matchCount) {
        if (matchCount >= MIN_MATCH_COUNT) {
            PrizePolicy prizePolicy = PrizePolicy.fromMatchCount(matchCount);
            winLottoTicket.put(prizePolicy, winLottoTicket.getOrDefault(prizePolicy, 0) + 1);
        }
    }

    public double rateOfReturnResult(int totalMoney, int totalPrizeMoney) {
        return Math.floor((double) totalPrizeMoney / totalMoney * 100) / 100.0;
    }

}
