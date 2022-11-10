package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;

public class BonusBall {
    LottoNumber lottoNumber;

    public BonusBall(String input, Lotto winningLotto) {
        lottoNumber = new LottoNumber(input);
        checkDuplicate(winningLotto);
    }

    private void checkDuplicate(Lotto winningLotto) {
        if (winningLotto.containLottoNumber(lottoNumber)) {
            throw new DuplicateLottoNumberException();
        }
    }
}
