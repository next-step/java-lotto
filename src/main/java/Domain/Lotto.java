package Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public void calculateAllRank(List<Integer> numbers) {
        for (Attempt attemptNumber : getLottoNumbers()) {
            attemptNumber.calculateRank(numbers);
        }
    }

}
