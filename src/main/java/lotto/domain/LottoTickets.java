package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import static java.util.stream.Collectors.*;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoNumbers> lottoNumbersList, LottoNumbers winningNumbers) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            lottoTickets.add(LottoTicket.of(lottoNumbers, winningNumbers));
        }
        return new LottoTickets(lottoTickets);
    }

    public LottoResult matchResult() {
        Map<Prize, Integer> result = Prize.defaultResultMap();
        lottoTickets.stream()
                .collect(toMap(LottoTicket::getPrize, ticket -> 1, Integer::sum))
                .forEach((prize, count) -> result.put(prize, result.get(prize) + count));
        return new LottoResult(result);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("\n");
        for (LottoTicket lottoTicket : lottoTickets) {
            joiner.add(lottoTicket.toString());
        }
        return joiner.toString();
    }
}
