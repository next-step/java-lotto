package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:46
 */
public class PurchasedLotto {

    private final List<Lotto> purchasedLotto;

    public PurchasedLotto(List<Lotto> purchasedLotto) {
        this.purchasedLotto = purchasedLotto;
    }

    public List<Lotto> getPurchasedLotto() {
        return this.purchasedLotto;
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

    public List<List<Integer>> getLottoNumbers() {
        return purchasedLotto.stream().map(Lotto::getLottoNumbers).collect(Collectors.toList());
    }
}
