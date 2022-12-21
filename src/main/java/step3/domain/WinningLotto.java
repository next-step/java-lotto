package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningLotto {

    private Map<Integer, Boolean> lottoNumbers = new HashMap<>();
    private int bonusNumber = 0;


    public WinningLotto(String[] input, int bonusNumber){
        for (String str : input) {
            lottoNumbers.put(Integer.parseInt(str), true);
        }
        this.bonusNumber = bonusNumber;
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
