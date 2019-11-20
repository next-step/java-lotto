package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoType implements CreatableLotto {

    private static final int LOTTO_GET_NUMBER = 6;
    private static final int ZERO = 0;

    @Override
    public List<LottoNo> makeLotto() {
        CreatableLotto creatableLotto = new LottoFactory().getLottoVersionSix();
        List<LottoNo> lottoPlatform = creatableLotto.makeLotto();

        List<LottoNo> lottoNumbers = new ArrayList<>();
        Collections.shuffle(lottoPlatform);
        for (int i = ZERO; i < LOTTO_GET_NUMBER; i++) {
            lottoNumbers.add(lottoPlatform.get(i));
        }
        return lottoNumbers;
    }
}
