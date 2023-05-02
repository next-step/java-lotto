package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> allNumber = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private final List<Integer> lottoNumber;

    public Lotto() {
        this.lottoNumber = new ArrayList<Integer>(markedNumber(this.allNumber));
    }

    private List<Integer> markedNumber(List<Integer> numberList) {
        Collections.shuffle(numberList);
        return sortNumber(numberList.subList(0, 6));
    }

    private List<Integer> sortNumber(List<Integer> numberList) {
        Collections.sort(numberList);
        return numberList;
    }

    public int checkLottoNumber(List<Integer> targetNumber) {
        return (int) targetNumber.stream().filter(this.lottoNumber::contains).count();
    }

    public List<Integer> checkedNumber() {
        return new ArrayList<>(this.lottoNumber);
    }

    public List<Integer> totalNumber() {
        return this.allNumber;
    }
}
