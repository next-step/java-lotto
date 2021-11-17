package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersList {
    private final List<RandomNumbers> randomNumbersList;

    public List<RandomNumbers> getRandomNumbersList() {
        return Collections.unmodifiableList(randomNumbersList);
    }

    public RandomNumbersList(Integer size) {
        List<RandomNumbers> randomNumbersList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            RandomNumbers randomNumbers = new RandomNumbers();
            randomNumbersList.add(randomNumbers);
        }
        this.randomNumbersList = randomNumbersList;
    }
}
