package lotto;

import java.util.*;
import java.util.stream.Collectors;


public class LottoGame {

    private Map<Integer, List<Integer>> result = new HashMap<>();

    public void add(int round, int[] winningNumber) {
        result.put(round, Arrays.stream(winningNumber).boxed().collect(Collectors.toList()));
    }

    public List<Integer> get(int round) {
        return result.get(round);
    }

    public int matchingCount(int round, LottoTicket lottoTicket) {

        List<Integer> winningNumbers = get(round);

        if(winningNumbers == null) {
            throw new IllegalArgumentException("존재하지 않는 회차입니다.");
        }

        return (int)lottoTicket.getLottoNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<LottoRank> lottoRanks(int round, List<LottoTicket> lottoTickets){
        return lottoTickets.stream()
                .map(lottoTicket -> matchingCount(round, lottoTicket))
                .map(LottoRank::valueOf)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public double revenueRate(int round, List<LottoTicket> lottoTickets) {
        long sum = lottoRanks(round, lottoTickets)
                .stream()
                .mapToLong(LottoRank::getPrice)
                .sum();

        return sum / (lottoTickets.size() * 1000);
    }
}
