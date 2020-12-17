package lotto.domain.machine;

import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoUserRequest;

public interface TicketMachine {
    boolean hasTarget(LottoUserRequest lottoUserRequest);

    List<LottoTicket> issue(LottoUserRequest lottoUserRequest);
}
