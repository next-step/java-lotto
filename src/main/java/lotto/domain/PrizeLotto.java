package lotto.domain;

import java.util.Set;

public class PrizeLotto  {

    private Set<Integer> prizeNumbers;

    public PrizeLotto(Set<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public boolean existByIndexNumber(int lottoNumber) {
        return prizeNumbers.contains(lottoNumber);
    }

}