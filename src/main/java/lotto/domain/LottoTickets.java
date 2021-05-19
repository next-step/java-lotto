package lotto.domain;

import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
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
            result.put(prize, result.getOrDefault(prize, 0) + 1);
        }
        return new LottoResult(result);
    }
}
