package lotto.domain;

import java.util.List;

public class ManualBuyDetails {
    private int count ;
    private List<LottoNumbers> lottoNumbers;

    public ManualBuyDetails(int count, List<LottoNumbers> lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("수동로또 번호 오류");
        }

        if (count != lottoNumbers.size()) {
            throw new IllegalArgumentException("수동로또 갯수가 일치하지 않습니다.");
        }
        this.count = count;
        this.lottoNumbers = lottoNumbers;
    }

    public int getCount() {
        return count;
    }

    public List<LottoNumbers> getLottoNumbers() {
        return lottoNumbers;
    }
}
