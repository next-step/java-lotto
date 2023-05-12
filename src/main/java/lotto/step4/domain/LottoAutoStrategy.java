package lotto.step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoStrategy implements LottoStrategy {
    @Override
    public Lotto createLotto() {
        List<Integer> lottoList = IntStream.rangeClosed(LOTTO_HEAD_NUMBER, LOTTO_LAST_NUMBER).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoList);

        return new Lotto(new TreeSet<>(lottoList.subList(0, LOTTO_NUMBER)));
    }
}
