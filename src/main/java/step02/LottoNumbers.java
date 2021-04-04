package step02;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbers(RandomNumberRule makeRandomNumberRule) {
        makeNumbers(makeRandomNumberRule);
    }

    private void makeNumbers(RandomNumberRule makeRandomNumberRule) {
        for (int numbers : makeRandomNumberRule.makeNumbers()) {
            lottoNumbers.add(new LottoNumber(numbers));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            stringBuilder.append(lottoNumbers.get(i).getLottoNumber());
            if (i < lottoNumbers.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
