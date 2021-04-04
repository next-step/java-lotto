package step02;

import java.util.ArrayList;
import java.util.List;

import static step02.LottoConfig.*;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(NumberRule numberRule) throws Exception {
        makeNumbers(numberRule);
    }

    private void makeNumbers(NumberRule numberRule) throws Exception {
        Validation.numberCount(numberRule.makeNumbers().size());
        for (int numbers : numberRule.makeNumbers()) {
            lottoNumbers.add(new LottoNumber(numbers));
        }
    }

    public int countCompareMathNumber(LottoNumbers winnerNumbers) {
        int countMath = 0;
        for (LottoNumber winnerNumber : winnerNumbers.lottoNumbers) {
            if (lottoNumbers.contains(winnerNumber)) {
                countMath++;
            }
        }
        return countMath;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ZERO; i < lottoNumbers.size(); i++) {
            stringBuilder.append(lottoNumbers.get(i).getLottoNumber());
            if (i < lottoNumbers.size() - ONE) {
                stringBuilder.append(REGEX + BLANK);
            }
        }
        return stringBuilder.toString();
    }
}
