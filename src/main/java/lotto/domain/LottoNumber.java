package lotto.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LottoNumber implements Iterable<Integer> {
    private final Set<Integer> pickedLotto;

    public LottoNumber(List<Integer> pickedLotto) {
        this.pickedLotto = new HashSet<>(pickedLotto);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) { return false; }
        LottoNumber lotto = (LottoNumber) obj;
        return lotto.containsAll(this.pickedLotto);
    }

    private boolean containsAll(Set<Integer> pickedLotto) {
        return this.pickedLotto.containsAll(pickedLotto);
    }

    @Override
    public Iterator<Integer> iterator() {
        return pickedLotto.iterator();
    }
}
