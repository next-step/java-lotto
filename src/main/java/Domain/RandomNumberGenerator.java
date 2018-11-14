package Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int DIGITS = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    @Override
    public List<Integer> getRandomNumber() {
        List<Integer> initNumbers = initNumbers();
        shuffleNumbers(initNumbers);

        List<Integer> attemptNumbers = initNumbers.subList(0, DIGITS);
        sortNumbers(attemptNumbers);

        return attemptNumbers;
    }

    private void sortNumbers(List<Integer> integers) {
        Collections.sort(integers);
    }

    private void shuffleNumbers(List<Integer> initNumbers) {
        Collections.shuffle(initNumbers);
    }

    private List<Integer> initNumbers() {
        List<Integer> initNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            initNumbers.add(i);
        }
        return initNumbers;
    }
}
