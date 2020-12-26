package lotto.oop.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    public static final int EXTRACT_FROM_FIRST_NUMBER = 0;
    public static final int EXTRACT_TO_LAST_NUMBER = 6;

    private List<Integer> number = new ArrayList<>();

    public void addNum(int num) {
        this.number.add(num);
    }

    public void shuffleNumber() {
        Collections.shuffle(number);
    }

    public void sortSixNumber() {
        List<Integer> sixNumber = new ArrayList<>(this.number.subList(EXTRACT_FROM_FIRST_NUMBER, EXTRACT_TO_LAST_NUMBER));
        Collections.sort(sixNumber);
        this.number = sixNumber;
    }

    public List<Integer> getNumber() {
        return number;
    }
}
