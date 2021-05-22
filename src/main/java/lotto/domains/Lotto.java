package lotto.domains;

import java.util.Arrays;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(){
        lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {

        this.lottoNumbers = lottoNumbers;
    }

    public int checkNumber(LottoNumbers winningNumber) {
        int matchingNumberCount = 0;
        for (int lottoNumber : lottoNumbers.lottoNumbers()) {
            if (winningNumber.contains(lottoNumber)) {
                matchingNumberCount++;
            }
        }
        return matchingNumberCount;
    }

    public String lottoNumbers() {
        return Arrays.toString(lottoNumbers.lottoNumbers().toArray());
    }
}
