package lotto;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = LottoFactory.create();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
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
}
