package lotto.application;

import lotto.domain.ticket.LottoNumber;

import java.util.List;

public interface LottoGenerator {
    List<LottoNumber> getLottoNumbers();
}
