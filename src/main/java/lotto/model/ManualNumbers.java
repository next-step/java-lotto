package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ManualNumbers implements Iterable<LottoNumbers> {
    private final List<LottoNumbers> manualNumbers = new ArrayList<>();

    public ManualNumbers(List<List<Integer>> lottoNumbersList) {
        for (List<Integer> lottoNumbers : lottoNumbersList) {
            manualNumbers.add(new LottoNumbers(lottoNumbers));
        }
    }

    public int size() {
        return manualNumbers.size();
    }

    @Override
    public Iterator<LottoNumbers> iterator() {
        return manualNumbers.iterator();
    }
}
