package step2.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningLotto {

    private Map<Integer, Boolean> lottoNumbers = new HashMap<>();
    private int bonusNumber = 0;

    public WinningLotto(List<Integer> input, int bonusNumber) {
        for (Integer num : input) {
            lottoNumbers.put(num, true);
        }
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String[] input, int bonusNumber) {
        this(Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList()), bonusNumber);
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
