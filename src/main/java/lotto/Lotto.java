package lotto;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = LottoFactory.createRandom();
    }

    public Lotto(String numbers) {
        lottoNumbers = LottoFactory.createManual(numbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lottoNumbers.size(); i++) {
            sb.append(lottoNumbers.get(i));
            if (i != lottoNumbers.size() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean contain(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
