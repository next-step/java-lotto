package raffle.lotto;

import static raffle.lotto.LottoMachine.LOTTO_MAX_NUMBER;
import static raffle.lotto.LottoMachine.LOTTO_MIN_NUMBER;

public class LottoNumber {
    private int lottoNumber;

    public LottoNumber(int lottoNumber){
        this.lottoNumber = lottoNumber;
        if(!isLottoNumber()){
            new RuntimeException("보너스 로또 범위의 숫자가 아닙니다.");
        }
    }

    public int getBonusnumber() {
        return lottoNumber;
    }

    public boolean isLottoNumber() {
        return  LOTTO_MIN_NUMBER <= lottoNumber && lottoNumber <= LOTTO_MAX_NUMBER;
    }

}
