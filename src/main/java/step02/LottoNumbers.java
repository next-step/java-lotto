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
        Validation.overMaxNumberCount(numberRule.makeNumbers().size());
        for (int numbers : numberRule.makeNumbers()) {
            lottoNumbers.add(new LottoNumber(numbers));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ZERO; i < lottoNumbers.size(); i++) {
            stringBuilder.append(lottoNumbers.get(i).getLottoNumber());
            if (i < lottoNumbers.size() - ONE) {
                stringBuilder.append(SEPARATOR_NUMBER);
            }
        }
        return stringBuilder.toString();
    }
}
