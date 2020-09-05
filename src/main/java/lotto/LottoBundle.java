package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class LottoBundle {

    private List<LottoNumbers> tickets;

    public LottoBundle(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public int count() {
        return tickets.size();
    }

    public Map<Prize, Integer> drawing(LottoNumbers winningNumbers) {
        Map<Prize, Integer> result = new HashMap<>();
        Map<Prize, List<LottoNumbers>> ticketsPerPrize = tickets.stream()
                .collect(groupingBy(lottoNumbers -> lottoNumbers.matchNumbers(winningNumbers)));

        for (Prize prize : ticketsPerPrize.keySet()) {
            result.put(prize, ticketsPerPrize.get(prize).size());
        }
        return result;
    }
}
