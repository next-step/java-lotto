package lotto.factory;

import lotto.generator.LottoNumberGenerator;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    private LottoFactory() {
    }

    public static Lotto manualCreateLotto(List<LottoNumbers> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public static Lotto autoCreateLotto(int count) {
        List<LottoNumbers> lotto = new ArrayList<>();
        LottoNumberGenerator generator = new LottoNumberGenerator();
        for (int i = 0; i < count; i++) {
            lotto.add(LottoNumberFactory.autoCreateNumbers(generator));
        }
        return new Lotto(lotto);
    }

    public static Lotto manualCreateSingleLotto(LottoNumbers lottoNumbers) {
        return new Lotto(Collections.singletonList(lottoNumbers));
    }
}
