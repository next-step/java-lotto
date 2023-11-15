package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShuffleStrategy implements ShuffleStrategy{

    @Override
    public List<Integer> shufflable(List<Integer> list) {
        List<Integer> buyLotto;
        Collections.shuffle(list);
        buyLotto = new ArrayList<>(list.subList(0,6));
        Collections.sort(buyLotto);
        return buyLotto;
    }
}
