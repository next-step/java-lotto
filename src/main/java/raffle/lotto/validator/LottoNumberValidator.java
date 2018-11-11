package raffle.lotto.validator;

import raffle.lotto.Lotto;

import java.util.List;

import static raffle.lotto.LottoMachine.LOTTO_MAX_NUMBER;
import static raffle.lotto.LottoMachine.LOTTO_MIN_NUMBER;

public class LottoNumberValidator implements LottoValidator {
    List<Lotto> lottos;

    @Override
    public boolean validator(List<Lotto> lottos) {
        this.lottos = lottos;
        if(isLottoNumber()){
            throw new RuntimeException("로또에 해당하는 번호가 아닙니다.");
        }
        return true;
    }

    private boolean isLottoNumber() {
        return lottos.stream().allMatch(lotto -> isLottoNumber(lotto));
    }

    private boolean isLottoNumber(Lotto lotto) {
        return !lotto.getLottoNumber().stream().allMatch(lottoNo -> LOTTO_MIN_NUMBER <= lottoNo.getLottoNumber()  && lottoNo.getLottoNumber() <= LOTTO_MAX_NUMBER);
    }

}
