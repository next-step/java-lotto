package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumber {

    private final Random random = new Random();
    private final int MAX_LOTTO_NUMBER = 45;
    private final int MIN_LOTTO_NUMBER = 1;

    public List<Integer> lottoNumber;
    public Integer hit;

    public LottoNumber() {
        this.lottoNumber = createLottoNumber();
        this.hit = 0;
    }

    public List<Integer> createLottoNumber() {
        List<Integer> collect = Stream.iterate(MIN_LOTTO_NUMBER, n -> n + 1).limit(MAX_LOTTO_NUMBER).collect(Collectors.toList());
        Collections.shuffle(collect);
        List<Integer> subList = new ArrayList<>(collect.subList(0,6));
        Collections.sort(subList);
        return subList;
    }


    @Override
    public String toString() {
        return "" + lottoNumber;
    }

    public int getHitCount(List<Integer> winningLotto) {
        return winningLotto.stream()
                .filter(lottoNumber::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum);
    }
}
