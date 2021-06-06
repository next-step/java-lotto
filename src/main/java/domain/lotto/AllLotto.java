package domain.lotto;

import java.util.ArrayList;
import java.util.List;

public class AllLotto {
    List<List<Integer>> lottoPapers = new ArrayList<>();

    public void add(List<Integer> lottoNumbers) {
        lottoPapers.add(lottoNumbers);
    }
}
