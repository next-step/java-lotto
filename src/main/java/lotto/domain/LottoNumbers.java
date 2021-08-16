package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoNumbers(LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        lottoNumbers.addAll(lottoNumberSelectPolicy.selectNumbers());
    }

    public LottoNumbers(final List<Integer> numbers) {
        lottoNumbers.addAll(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int getSameCount(LottoNumbers winningNumbers) {
        int collectNumber = 0;
        List<Integer> integerWinningNumbers = winningNumbers.getLottoNumbers();
        for (Integer number : integerWinningNumbers) {
            collectNumber += checkContains(number);
        }
        return collectNumber;
    }

    private int checkContains(int number){
        if(lottoNumbers.contains(number)){
            return 1;
        }
        return 0;
    }
}
