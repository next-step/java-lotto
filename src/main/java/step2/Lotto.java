package step2;

import java.util.List;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        lottoNumbers = new LottoNumbers();
    }

    //랜덤값 테스트를 위한 protected 생성자
    protected Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public int getMatchCount(Lotto winner) {
        return lottoNumbers.getMatchCount(winner.lottoNumbers);
    }
}
