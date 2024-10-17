package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class QuickPickGenerator{

    public static List<LottoNumbers> genLottoNumbers(int cnt) {
        List<LottoNumbers> generatedNumbers = new ArrayList<>();
        List<Integer> numberPool = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numberPool.add(i);
        }
        List<Integer> newArr = null;
        for (int i = 0; i < cnt; i++) {
            Collections.shuffle(numberPool);
            newArr = new ArrayList<>();
            newArr = numberPool.subList(0,6);
            generatedNumbers.add(new LottoNumbers(newArr.stream().map(x->new LottoNumber(x)).collect(Collectors.toList())));
        }
        return generatedNumbers;
    }

}
