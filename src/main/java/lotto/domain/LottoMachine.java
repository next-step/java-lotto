package lotto.domain;

public interface LottoMachine {
    LottoTicket createLotto(LottoRequest lottoRequest);
}
