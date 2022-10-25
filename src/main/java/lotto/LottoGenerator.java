package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Winning.*;

public class LottoGenerator {
    private final LottoCollection collection;

    public LottoGenerator(int quantity) {
        this.collection = new LottoCollection(addLotto(quantity));
    }

    public List<List<Integer>> addLotto(int quantity) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public List<Integer> createLotto() {
        List<Integer> range = collectNumbers();
        Collections.shuffle(range);

        range = range.subList(0, 6);
        Collections.sort(range);

        return range;
    }

    public LottoCollection getCollection() {
        return collection;
    }

    private ArrayList<Integer> collectNumbers() {
        return IntStream.range(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
