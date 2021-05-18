import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoModel {

    private final List<Integer> autoNumbers = new ArrayList<>();

    LottoAutoModel() {
        List<Integer> rangeOfNumbers = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            rangeOfNumbers.add(i + 1);
        }

        Collections.shuffle(rangeOfNumbers);
        for (int j = 0; j < 6; j++) {
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
        for (int i = 0; i < 6; i++) {
            if (autoNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
