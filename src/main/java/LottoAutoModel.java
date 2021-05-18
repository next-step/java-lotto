import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoModel {
    private final List<Integer> autoNumbers = new ArrayList<>();
    private static final int numberOfNumbers = 6;
    private static final int maxNumber = 45;

    LottoAutoModel() {
        List<Integer> rangeOfNumbers = new ArrayList<>();
        for (int i = 0; i < maxNumber; i++) {
            rangeOfNumbers.add(i + 1);
        }

        Collections.shuffle(rangeOfNumbers);
        for (int j = 0; j < numberOfNumbers; j++) {
            autoNumbers.add(rangeOfNumbers.get(j));
        }
        Collections.sort(autoNumbers);
    }

    public List<Integer> getAutoNumbers() {
        return autoNumbers;
    }

    public boolean contains(int bonusNumber) {
            return autoNumbers.contains(bonusNumber);
    }

    public int setWinningResult(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < numberOfNumbers; i++) {
            if (autoNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
