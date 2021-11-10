package lotto.service.model;

import lotto.service.domain.LottoTicket;
import lotto.service.domain.WinningLottoTicket;
import lotto.service.domain.types.Rank;
import lotto.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        Preconditions.checkNotNull(lottoTickets, "lottoTickets는 필수값 입니다.");

        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(List<LottoTicket> numbers) {
        return new LottoTickets(numbers);
    }

    public Map<Rank, Integer> countOfWinningByRank(WinningLottoTicket winningLottoTicket) {
        return lottoTickets.stream()
                .map(ticket -> Rank.convertRankByCountOfMatch(winningLottoTicket.getCountOfMatch(ticket),
                                                              winningLottoTicket.isBonusNumberMatch(ticket)))
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));
    }

    boolean isBonusNumberMatch(WinningLottoTicket winningLottoTicket) {
        return lottoTickets.stream()
                .anyMatch(winningLottoTicket::isBonusNumberMatch);
    }

    public Integer getCountOfLottoTickets() {
        return lottoTickets.size();
    }

    /**
     * only view 에서만 사용
     */
    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(new ArrayList<>(lottoTickets));
    }
}
