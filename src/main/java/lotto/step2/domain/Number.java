package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Number {

    List<Integer> number = new ArrayList<>();

    public Number() {
        createRandomNumber();
    }

    public List<Integer> getNumber() {
        return number;
    }

    private void createRandomNumber() {
        for (int i = 0; i < 6; i++) {
            number.add(new Random().nextInt(45) + 1);
        }
    }

}
