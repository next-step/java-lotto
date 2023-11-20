package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numList = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    private final List<Integer> lottoNumberList;

    public Lotto(){
        shuffle();
        this.lottoNumberList = numList.subList(0, 6);
        sort();
    }

    private void shuffle(){
        Collections.shuffle(numList);
    }

    private void sort(){
        Collections.sort(this.lottoNumberList);
    }

    public List<Integer> getLottoNumberList() {
        return this.lottoNumberList;
    }
}
