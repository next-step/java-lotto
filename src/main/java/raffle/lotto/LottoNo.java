package raffle.lotto;

import static raffle.lotto.LottoMachine.LOTTO_MAX_NUMBER;
import static raffle.lotto.LottoMachine.LOTTO_MIN_NUMBER;

public class LottoNo implements Comparable<LottoNo> {
    private int lottoNumber;

    public LottoNo(int lottoNumber){
        this.lottoNumber = lottoNumber;
        if(!isLottoNumber()){
            new RuntimeException("보너스 로또 범위의 숫자가 아닙니다.");
        }
    }

    public boolean isLottoNumber() {
        return  LOTTO_MIN_NUMBER <= lottoNumber && lottoNumber <= LOTTO_MAX_NUMBER;
    }

    @Override
    public int compareTo(LottoNo lottoNumber) {
        return Integer.compare(this.lottoNumber, lottoNumber.getLottoNumber());
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
