package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;

import java.util.Set;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_CAPACITY = 6;
    private Set<Integer> lottoNumbers;

    public LottoNumbers(LottoMachine lottoMachine) {
        Set<Integer> createdLottoNumbers = lottoMachine.createLottoNumber(6);
        validateLottoNumbers(createdLottoNumbers);
        lottoNumbers = createdLottoNumbers;
    }

    private void validateLottoNumbers(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_CAPACITY) {
            throw new NotValidLottoNumberException(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
        }
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int countPrizeMatchLottoNumber(PrizeLotto prizeLotto) {
        validateLottoNumbers(prizeLotto.getPrizeNumbers());
        return (int) lottoNumbers.stream()
                                 .filter(prizeLotto::findByIndexNumber)
                                 .count();
    }
}
