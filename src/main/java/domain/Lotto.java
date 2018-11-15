package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private int amount;
    private List<Attempt> lottoNumbers;

    public Lotto(int amount, NumberGenerator generator) {
        this.amount = amount;
        initLottoNumbers(amount, generator);
    }

    private void initLottoNumbers(int amount, NumberGenerator generator) {
        List<Attempt> tempLottoNumber = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tempLottoNumber.add(new Attempt(generator));
        }
        this.lottoNumbers = tempLottoNumber;
    }

    public List<Attempt> getLottoNumbers() {
        return lottoNumbers;
    }

    public void calculateAllRank(List<Integer> numbers, int bonusNumber) {
        for (Attempt attemptNumber : getLottoNumbers()) {
            attemptNumber.calculateRank(numbers, bonusNumber);
        }
    }

}
