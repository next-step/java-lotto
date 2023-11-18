package lotto.domain;

import java.util.*;

public class LottoGeneration {

    List<Lotto> lottoList;

    public LottoGeneration(List<List<Integer>> manualNumbers, NumberGeneration numberGeneration, int count) {
        List<Lotto> list = new ArrayList<>();
        int randomCount = count - manualNumbers.size();

        manualGenerate(manualNumbers, list);
        autoGenerate(numberGeneration, randomCount, list);

        this.lottoList = list;
    }

    private void autoGenerate(NumberGeneration numberGeneration, int randomCount, List<Lotto> list) {
        for (int i = 0; i < randomCount; i++) {
            list.add(new Lotto(numberGeneration.generate()));
        }
    }

    private void manualGenerate(List<List<Integer>> manualNumbers, List<Lotto> list) {
        for (List<Integer> manualNumber : manualNumbers) {
            list.add(new Lotto(manualNumber));
        }
    }

    public List<Lotto> find() {
        return Collections.unmodifiableList(lottoList);
    }
}
