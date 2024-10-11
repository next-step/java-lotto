package lotto.domain;

import java.util.*;

public class QuickPickGenerator implements LottoNumberGenerator {

    @Override
    public  List<List<Integer>> genLottoNumbers(int cnt) {
        List<List<Integer>> generatedNumbers = new ArrayList<>();
        List<Integer> numberPool = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numberPool.add(i);
        }
        List<Integer> newArr = null;
        for (int i = 0; i < cnt; i++) {
            Collections.shuffle(numberPool);
            newArr = new ArrayList<>();
            newArr.addAll(numberPool.subList(0,6)) ;
            generatedNumbers.add(newArr);
        }
        return generatedNumbers;
    }

}
