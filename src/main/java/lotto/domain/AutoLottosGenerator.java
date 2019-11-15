package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottosGenerator implements LottosGenerator {
    private static final int LOTTO_GET_NUMBER = 6;
    private static final int ZERO = 0;
    private Money money;

    public AutoLottosGenerator(Money money) {
        this.money = money;
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> lottoPapers = new ArrayList<>();
        int count = this.money.purchaseCount();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(createRandomLottoNumber());
            lottoPapers.add(lotto);
        }
        return lottoPapers;
    }
    
    private List<LottoNo> createRandomLottoNumber() {
        CreatableLotto creatableLotto = new LottoFactory().getLottoVersionSix();
        List<LottoNo> allLottoNumber = creatableLotto.makeLotto();
        List<LottoNo> lottoNumbers = new ArrayList<>();
        Collections.shuffle(allLottoNumber);
        for (int i = ZERO; i < LOTTO_GET_NUMBER; i++) {
            lottoNumbers.add(allLottoNumber.get(i));
        }
        return lottoNumbers;
    }
}
