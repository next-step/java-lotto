package lotto.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllNumbers {
    private List<Integer> allNumbers;

    public AllNumbers() {
        List<Integer> initNumbers = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            initNumbers.add(i + 1);
        }

        this.allNumbers = initNumbers;
    }

    public List<Integer> getRandomNumbers() {
        Collections.shuffle(allNumbers);

        return allNumbers;
    }
}
