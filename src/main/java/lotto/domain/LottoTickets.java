package lotto.domain;

import lotto.utils.StringUtils;

import java.util.*;

public class LottoTickets {
    public static final int ZERO = 0;
    public static final int ADD_NUMBER = 1;
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<String> tickets) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (String ticket : tickets) {
            lottoTickets.add(LottoTicket.of(StringUtils.toIntegerList(ticket)));
        }
        return new LottoTickets(lottoTickets);
    }

    public int size() {
        return this.lottoTickets.size();
    }

    public LottoResult matchResult(LottoTicket winningNumbers) {
        Map<Prize, Integer> result = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            Prize prize = lottoTicket.match(winningNumbers);
            result.put(prize, result.getOrDefault(prize, ZERO) + ADD_NUMBER);
        }
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
