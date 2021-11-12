package lotto.service.model;

import lotto.service.domain.LottoTicket;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.domain.types.Rank;
import lotto.service.value.LottoPrice;
import lotto.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.rule.LottoRule.MINIMUM_PRICE;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        Preconditions.checkNotNull(lottoTickets, "lottoTickets는 필수값 입니다.");

        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(List<LottoTicket> numbers) {
        return new LottoTickets(numbers);
    }

    public static LottoTickets of(List<LottoTicket> manualNumbers, List<LottoTicket> autoNumbers) {
        List<LottoTicket> totalNumbers = new ArrayList<>();
        totalNumbers.addAll(autoNumbers);
        totalNumbers.addAll(manualNumbers);
        return new LottoTickets(totalNumbers);
    }

    public Map<Rank, Integer> countOfWinningByRank(WinningLottoTicket winningLottoTicket) {
        return lottoTickets.stream()
                .map(winningLottoTicket::matchRank)
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
    }

    public Integer getCountOfLottoTickets() {
        return lottoTickets.size();
    }

    public LottoPrice getLottoPrice() {
        return LottoPrice.from(getCountOfLottoTickets() * MINIMUM_PRICE);
    }

    public Integer getAutoLottoCount(Integer manualLottoCount) {
        return getCountOfLottoTickets() - manualLottoCount;
    }

    /**
     * only view 에서만 사용
     */
    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(new ArrayList<>(lottoTickets));
    }
}
