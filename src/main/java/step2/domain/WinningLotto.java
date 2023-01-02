package step2.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningLotto {

    private Map<LottoNumber, Boolean> lottoNumbers = new HashMap<>();
    private LottoNumber bonusNumber;

    public WinningLotto(List<Integer> input, int bonusNumber) {
        for (Integer num : input) {
            lottoNumbers.put(LottoNumber.of(num), true);
        }
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public WinningLotto(String[] input, int bonusNumber) {
        this(Arrays.stream(input).map(Integer::parseInt).collect(Collectors.toList()), bonusNumber);
    }

    public WinningLotto(String input, int bonusNumber) {
        this(input.split(", "), bonusNumber);
    }

    public Map<LottoNumber, Boolean> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
