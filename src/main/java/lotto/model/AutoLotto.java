package lotto.model;

public class AutoLotto {

    public static LottoNumbers getAutoLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        return lottoNumbers.generateNumbers();
    }

}
