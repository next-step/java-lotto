package lotto.controller;

import lotto.entity.Lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.entity.LottoNumber;
import lotto.entity.Lottos;
import lotto.entity.PrizePolicy;

public class LottoMachine {
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

    public List<Integer> checkMatchingNumber(String inputWinningNumbers) {
        Lotto winningLotto = new Lotto(inputWinningNumbers);

        List<Integer> matchingLottoTickets = totalLottoTicket.getValues().stream()
                .map(lottoTicket ->
                        (int) lottoTicket.getLottoNumbers().stream()
                                .filter(lottoNumber ->
                                        winningLotto.getLottoNumbers().stream()
                                                .map(LottoNumber::getNumber)
                                                .collect(Collectors.toList())
                                                .contains(lottoNumber.getNumber())
                                )
                                .count()
                )
                .collect(Collectors.toList());

        Collections.sort(matchingLottoTickets);
        return matchingLottoTickets;
    }

    public Map<Integer, Integer> winningResult(List<Integer> matchingLottoTickets) {
        Map<Integer, Integer> winLottoTicket = new HashMap<>();
        for (Integer matchCount : matchingLottoTickets) {
            //winLottoTicket.put(PrizePolicy.fromMatchCount(matchCount), winLottoTicket.getOrDefault(PrizePolicy.fromMatchCount(matchCount), 0) + 1);
            winLottoTicket.put(matchCount, winLottoTicket.getOrDefault(matchCount, 0) + 1);
        }
        return winLottoTicket;
    }

    public double rateOfReturnResult(int totalMoney, int totalPrizeMoney) {
        return Math.floor((double) totalPrizeMoney / totalMoney * 100) / 100.0;
    }

}
