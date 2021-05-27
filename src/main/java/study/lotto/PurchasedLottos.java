package study.lotto;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    List<LottoNumbers> lottoNumbers;

    public PurchasedLottos(int lottoPapers) {
        List<LottoNumbers> purchasedLottos = new ArrayList<>();
        while (purchasedLottos.size() < lottoPapers) {
            LottoNumbers purchaseLotto = LottoNumbers.randomNumbers();
            purchasedLottos.add(purchaseLotto);
        }
        this.lottoNumbers = purchasedLottos;
    }

    public PurchasedLottos(List<LottoNumbers> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumbers> values() {
        return lottoNumbers;
    }

    public int count() {
        return lottoNumbers.size();
    }
}
