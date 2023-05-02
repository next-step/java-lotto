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
        this.lottoNumber = new ArrayList<>(markedNumber(this.allNumber));
    }

    private List<Integer> markedNumber(List<Integer> numberList) {
        Collections.shuffle(numberList);
        Collections.sort(numberList);
        return numberList.subList(0, 6);
    }

    public List<Integer> checkNumber() {
        return new ArrayList<>(this.lottoNumber);
    }

    public List<Integer> checkAllNumber() {
        return this.allNumber;
    }
}
