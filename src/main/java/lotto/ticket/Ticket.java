package lotto.ticket;

import lotto.LottoNumbers;

import java.util.List;

public interface Ticket {
    List<LottoNumbers> generateTickes(int count);
}
