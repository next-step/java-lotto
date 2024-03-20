package lotto.domain;

import java.util.Iterator;
import java.util.List;

public class LottoNumber implements Iterable<Integer> {
    private static final int MATCH_COUNT = 1;
    private static final int NOT_MATCH_COUNT = 0;

    private final List<Integer> pickedLotto;

    public LottoNumber(List<Integer> pickedLotto) {
        this.pickedLotto = pickedLotto;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) { return false; }
        LottoNumber lotto = (LottoNumber) obj;
        return lotto.containsAll(this.pickedLotto);
    }

    private boolean containsAll(List<Integer> pickedLotto) {
        return this.pickedLotto.containsAll(pickedLotto);
    }

    public int contains(int number) {
        if (pickedLotto.contains(number)) {
            return MATCH_COUNT;
        }
        return NOT_MATCH_COUNT;
    }

    @Override
    public Iterator<Integer> iterator() {
        return pickedLotto.iterator();
    }
}
