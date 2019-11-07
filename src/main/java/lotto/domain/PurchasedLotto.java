package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:46
 */
public class PurchasedLotto {

    private static final LottoNumberStrategy LOTTO_NUMBER_STRATEGY = new LottoNumberStrategy();

    private final List<Lotto> purchasedLotto;

    public PurchasedLotto(int lottoAmount) {
        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            purchasedLotto.add(new Lotto(LOTTO_NUMBER_STRATEGY.generateLottoNumber()));
        }
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return this.purchasedLotto;
    }

    public List<List<Integer>> getLottoNumbers() {
        return purchasedLotto.stream().map(Lotto::getLottoNumbers).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasedLotto that = (PurchasedLotto) o;
        return Objects.equals(purchasedLotto, that.purchasedLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchasedLotto);
    }
}
