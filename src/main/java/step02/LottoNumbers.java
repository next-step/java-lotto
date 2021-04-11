package step02;

import java.util.HashSet;
import java.util.Set;

import static step02.LottoConfig.*;

public class LottoNumbers {

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoNumbers(NumberRule numberRule)  {
        makeNumbers(numberRule);
    }

    private void makeNumbers(NumberRule numberRule) {
        Validation.numberCount(numberRule.makeNumbers().size());
        for (int numbers : numberRule.makeNumbers()) {
            lottoNumbers.add(new LottoNumber(numbers));
        }
    }

    public int countCompareMatchNumber(LottoNumbers winnerNumbers) {
        int countMatch = ZERO;
        for (LottoNumber winnerNumber : winnerNumbers.lottoNumbers) {
            countMatch += mathingCount(winnerNumber);
        }
        return countMatch;
    }

    private int mathingCount(LottoNumber winnerNumber) {
        if (lottoNumbers.contains(winnerNumber)) {
            return ONE;
        }
        return ZERO;
    }

    private void addSeparate(int index, StringBuilder stringBuilder) {
        if (index < lottoNumbers.size() - ONE) {
            stringBuilder.append(REGEX + BLANK);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = ZERO;

        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.getLottoNumber());
            addSeparate(index, stringBuilder);
            index++;
        }

        return stringBuilder.toString();
    }
}
