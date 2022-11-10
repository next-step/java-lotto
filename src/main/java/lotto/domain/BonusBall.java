package lotto.domain;

import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.NotPositiveException;
import org.apache.commons.lang3.StringUtils;

public class BonusBall {
    int lottoNumber;

    public BonusBall(String input, Lotto winningLotto) {
        checkNull(input);
        lottoNumber = inputToBonusBall(input);
        checkDuplicate(winningLotto);
    }

    private int inputToBonusBall(String input) {
        checkNotPositive(input);
        return Integer.parseInt(input);
    }

    private void checkNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new NotPositiveException();
        }
    }

    private void checkNotPositive(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new NotPositiveException();
        }
        if (Integer.parseInt(input) < 1) {
            throw new NotPositiveException();
        }
    }

    private void checkDuplicate(Lotto winningLotto) {
        if (winningLotto.containLottoNumber(lottoNumber)) {
            throw new DuplicateLottoNumberException();
        }
    }



}
