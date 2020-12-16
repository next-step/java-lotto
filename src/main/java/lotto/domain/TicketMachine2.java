package lotto.domain;

import java.util.List;

public interface TicketMachine2 {
    boolean hasTarget(LottoUserRequest lottoUserRequest);

    List<LottoTicket> issue(LottoUserRequest lottoUserRequest);
}
