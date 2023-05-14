package step2.domain;

import step2.domain.Lotto;

import java.util.ArrayList;

public class LottoNumbers {

    private final ArrayList<Lotto> lottoNumbers;

    public LottoNumbers(ArrayList<Lotto> input) {
        this.lottoNumbers = new ArrayList<>(input);
    }

    public ArrayList<Lotto> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public int compareLottoNumbers(ArrayList<Lotto> inputLotto) {

        int matchCount = 0;

        for(int i = 0; i < 6; i++) {
            if (inputLotto.get(i).isEqual(this.lottoNumbers.get(i))) {
                matchCount++;
            }
        }
        System.out.println("matchCount = " + matchCount);
        return matchCount;
    }

}
