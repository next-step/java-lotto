package lotto.service.model;

import lotto.service.domain.LottoTicket;
import lotto.service.domain.WinningLottoNumber;
import lotto.utils.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public List<Integer> getMatchingCountOfAllLottoTicket(WinningLottoNumber winningLottoNumber) {
        return lottoTickets.stream()
                .map(winningLottoNumber::getMatchingCount)
                .collect(Collectors.toList());
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
