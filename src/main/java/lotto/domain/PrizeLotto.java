package lotto.domain;

import java.util.Set;

public class PrizeLotto  {

    private Set<Integer> prizeNumbers;
    private int bonusBall;

    public PrizeLotto(Set<Integer> prizeNumbers, int bonusBall) {
        this.prizeNumbers = prizeNumbers;
        this.bonusBall = bonusBall;
    }

    public boolean matchBonusBall(int lottoNumber){
        return lottoNumber == bonusBall;
    }

    public boolean existByIndexNumber(int lottoNumber) {
        return prizeNumbers.contains(lottoNumber);
    }

}