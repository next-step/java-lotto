package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class AutoLottoNumberGenerator implements LottoNumberGenerator{

    private int count;

    public AutoLottoNumberGenerator(int count) {
        this.count = count;
    }

    @Override
    public List<LottoNumbers> generate() {
        List<LottoNumbers> generatedNumbers = new ArrayList<>();
        List<Integer> numberPool = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numberPool.add(i);
        }
        List<Integer> newArr = null;
        for (int i = 0; i < this.count; i++) {
            Collections.shuffle(numberPool);
            newArr = new ArrayList<>();
            newArr = numberPool.subList(0, 6);
            generatedNumbers.add(new LottoNumbers(newArr.stream().map(x -> new LottoNumber(x)).collect(Collectors.toList())));
        }
        return generatedNumbers;
    }
}