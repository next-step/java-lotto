package lotto.domain.generator;

import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaticLottoTicketGenerator implements LottoTicketGenerator {
    private final List<LottoNumber> lottoNumbers;

    public StaticLottoTicketGenerator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    @Override
    public LottoTicket generate()  {
        return new LottoTicket(new ArrayList<>(this.lottoNumbers));
    }
}
