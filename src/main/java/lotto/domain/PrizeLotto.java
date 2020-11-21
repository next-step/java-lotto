package lotto.domain;

import lotto.domain.util.PrizeNumberValidator;

import java.util.Set;

public class PrizeLotto  {

    private Set<Integer> prizeNumbers;

    public PrizeLotto(Set<Integer> prizeNumbers) {
        PrizeNumberValidator.validate(prizeNumbers);
        this.prizeNumbers = prizeNumbers;
    }

    public int size(){
        return prizeNumbers.size();
    }

    public boolean findByIndexNumber(int lottoNumber) {
        return prizeNumbers.contains(lottoNumber);
    }
}