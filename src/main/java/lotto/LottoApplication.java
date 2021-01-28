package lotto;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumbersPicker;

public class LottoApplication {

    public static void main(String[] args) {
        // purchaseAmount 입력 받기

        // LottoNumbers n개 생성 ... (n회 반복)
        LottoNumbers lottoNumbers = new LottoNumbers(LottoNumbersPicker.pick());

    }
}
