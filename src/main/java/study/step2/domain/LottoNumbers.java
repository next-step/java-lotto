package study.step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    public static final int POOL_START_NUMBER = 1;
    public static final int POOL_END_NUMBER = 45;
    private List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers() {
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> pool() {
        return IntStream.rangeClosed(POOL_START_NUMBER, POOL_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());
    }

    public void add(int number) {
        lottoNumbers.add(number);
    }

    public void sort() {
        Collections.sort(lottoNumbers);
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }

}
