package lotto.domain;

public interface LottoMachine {

    Lotto issue();

    Lotto issue(final String directLottoNumber);
}
