package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TotalNumbers {

    private final List<Integer> numberList = new ArrayList<>();

    public TotalNumbers() {
        for (int i = 1; i <= 45; i++) {
            this.numberList.add(i);
        }
    }

    public List<Integer> getList() {
        return this.numberList;
    }

    public List<Integer> getRandomNumber() {
        Collections.shuffle(numberList);
        List<Integer> lottoNumber = numberList.subList(0, 6);
        Collections.sort(lottoNumber);

        return lottoNumber;
    }
}
