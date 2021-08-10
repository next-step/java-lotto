package step3.util;

import java.util.Iterator;
import java.util.List;

public class LottoManualNumberGenerator implements LottoNumberGenerator {
    private final Iterator<List<Integer>> iterator;

    public LottoManualNumberGenerator(List<List<Integer>> manualNumbersList) {
        this.iterator = manualNumbersList.iterator();
    }

    @Override
    public List<Integer> generateNumbersForLotto() {
        return iterator.next();
    }
}
