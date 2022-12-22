package step3.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WinningLotto {

    private Map<Integer, Boolean> lottoNumbers = new HashMap<>();
    private int bonusNumber = 0;

    public WinningLotto(Integer[] input, int bonusNumber) {
        for (Integer num : input) {
            lottoNumbers.put(num, true);
        }
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String[] input, int bonusNumber) {
        this(Arrays.stream(input).map(Integer::parseInt).toArray(Integer[]::new), bonusNumber);
    }

    public WinningLotto(String input, int bonusNumber) {
        this(input.split(", "), bonusNumber);
    }

    public Map<Integer, Boolean> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
