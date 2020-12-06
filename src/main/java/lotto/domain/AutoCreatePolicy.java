package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoCreatePolicy {
    private static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    public LottoTicket create() {
        Collections.shuffle(lottoNumbers);

        List<LottoNumber> newTicketNumbers = AutoCreatePolicy.lottoNumbers.subList(0, 6);

        return new LottoTicket(newTicketNumbers);
    }
}
