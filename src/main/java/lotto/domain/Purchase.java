package lotto.domain;

import java.util.List;

public interface Purchase {
    List<LottoTicket> buy();
    int getAmount();
}