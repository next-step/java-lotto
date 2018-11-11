package raffle.lotto;

import static raffle.lotto.LottoMachine.LOTTO_MAX_NUMBER;
import static raffle.lotto.LottoMachine.LOTTO_MIN_NUMBER;

public class LottoNo {
    private int bonusnumber;

    public LottoNo(int bonusnumber){
        this.bonusnumber = bonusnumber;
        if(!isLottoNumber()){
            new RuntimeException("보너스 로또 범위의 숫자가 아닙니다.");
        }
    }

    public int getBonusnumber() {
        return bonusnumber;
    }

    public boolean isLottoNumber() {
        return  LOTTO_MIN_NUMBER <= bonusnumber && bonusnumber <= LOTTO_MAX_NUMBER;
    }
}
