package lotto.domain.lotto;

import lotto.domain.rank.Rank;
import lotto.domain.rank.RankCalculator;
import lotto.domain.rank.Ranks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> values;

    private LottoTickets(List<LottoTicket> values) {
        this.values = values;
    }

    public static LottoTickets create(List<LottoTicket> values) {
        return new LottoTickets(Collections.unmodifiableList(new ArrayList<>(values)));
    }

    public int size() {
        return this.values.size();
    }

    public Ranks calculateRanks(RankCalculator rankCalculator) {
        List<Rank> rankList = values.stream()
                .map(rankCalculator::getRank)
                .collect(Collectors.toList());
        return Ranks.create(rankList);
    }

    public List<LottoTicket> getValues() {
        return Collections.unmodifiableList(new ArrayList<>(values));
    }
}
