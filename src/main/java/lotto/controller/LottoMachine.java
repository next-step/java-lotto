package lotto.controller;

import lotto.entity.Lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.entity.LottoNumber;

public class LottoMachine {
    private List<Lotto> totalLottoTicket;

    public LottoMachine() {
        totalLottoTicket = new ArrayList<>();
    }

    public Lotto makeLottoTicket() {
        return new Lotto();
    }

    public List<Lotto> makeTotalLottoTickets(int totalTicketCount) {
        IntStream.range(0, totalTicketCount)
                .mapToObj(i -> makeLottoTicket())
                .forEach(totalLottoTicket::add);
        return totalLottoTicket;
    }

    public List<Integer> checkMatchingNumber(String inputWinningNumbers) {
        Lotto winningLotto = new Lotto(inputWinningNumbers);

        List<Integer> matchingLottoTickets = totalLottoTicket.stream()
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
            winLottoTicket.put(matchCount, winLottoTicket.getOrDefault(matchCount, 0) + 1);
        }
        return winLottoTicket;
    }

    public double rateOfReturnResult(int totalMoney, int totalPrizeMoney) {
        return Math.floor((double) totalPrizeMoney / totalMoney * 100) / 100.0;
    }

}
