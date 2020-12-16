package lotto.domain.machine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoUserRequest;

public class FixedTicketMachine implements TicketMachine {

    @Override
    public boolean hasTarget(LottoUserRequest lottoUserRequest) {
        return true;
    }

    @Override
    public List<LottoTicket> issue(LottoUserRequest lottoUserRequest) {
        Set<LottoNumber> lottoNumbers = new HashSet<LottoNumber>() {{
            add(new LottoNumber(1));
            add(new LottoNumber(2));
            add(new LottoNumber(3));
            add(new LottoNumber(4));
            add(new LottoNumber(5));
            add(new LottoNumber(6));
        }};

        return Stream.generate(() -> new LottoTicket(lottoNumbers))
              .limit(1)
              .collect(Collectors.toList());
    }
}
