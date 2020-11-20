package lotto.domain;

import lotto.domain.util.PrizeNumberValidator;

import java.util.HashSet;

public class PrizeLotto  {

    private HashSet<Integer> prizeNumbers;

    public PrizeLotto(HashSet<Integer> prizeNumbers) {
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