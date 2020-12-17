package lotto.domain.machine;

import java.util.Arrays;
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
        Set<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(
              new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
              new LottoNumber(5), new LottoNumber(6)
        ));

        return Stream.generate(() -> new LottoTicket(lottoNumbers))
              .limit(lottoUserRequest.getTicketCount())
              .collect(Collectors.toList());
    }
}
