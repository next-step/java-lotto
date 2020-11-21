package lotto.domain;

import java.util.Set;

public class PrizeLotto  {

    private Set<Integer> prizeNumbers;

    public PrizeLotto(Set<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public int size(){
        return prizeNumbers.size();
    }

    public boolean findByIndexNumber(int lottoNumber) {
        return prizeNumbers.contains(lottoNumber);
    }

    public Set<Integer> getPrizeNumbers() {
        return prizeNumbers;
    }
}