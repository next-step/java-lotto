package lotto.oop.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private static final int EXTRACT_FROM_FIRST_NUMBER = 0;
    private static final int EXTRACT_TO_LAST_NUMBER = 6;

    private List<Integer> number = new ArrayList<>();

    public void generateNumbers() {
        for (int i = 1; i <= 45; i++) {
            number.add(i);
        }
        shuffleNumber();
        sortSixNumber();
    }

    public void shuffleNumber() {
        Collections.shuffle(number);
    }

    public void sortSixNumber() {
        List<Integer> sixNumber = new ArrayList<>(this.number.subList(EXTRACT_FROM_FIRST_NUMBER, EXTRACT_TO_LAST_NUMBER));
        Collections.sort(sixNumber);
        this.number = sixNumber;
    }

    public int confrimLotto(LottoNumber list, String[] numbers) {
        int num = 0;
        for (int i = 0; i < numbers.length; i++) {
            num += verifyNumCount(list, numbers, i);
        }
        return num;
    }

    private int verifyNumCount(LottoNumber list, String[] numList, int i) {
        if (list.getNumber().contains(Integer.parseInt(numList[i]))) {
            return 1;
        }
        return 0;
    }

    public List<Integer> getNumber() {
        return number;
    }
}
