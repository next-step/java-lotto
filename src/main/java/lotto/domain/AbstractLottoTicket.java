package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractLottoTicket {

    private static final Integer LOTTO_SIZE = 6;

    protected final Set<LottoNumber> lottoTicket;

    protected AbstractLottoTicket(List<Integer> lottoNumber) {
        Set<LottoNumber> lottoTicket = generateHashSetLottoNumber(lottoNumber);
        valid(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    private void valid(Set<LottoNumber> lottoTicket) {
        if (lottoTicket.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 티켓은 %d개 여야 합니다.", LOTTO_SIZE));
        }
    }

    private Set<LottoNumber> generateHashSetLottoNumber(List<Integer> lottoTicket) {
        return lottoTicket.stream()
            .map(LottoNumber::from)
            .collect(Collectors.toCollection(HashSet::new));
    }


}
