package domain;

import java.util.List;

public class Lotto {

    private LottoNumbers lottoNumbers;

    public static final int SIZE_LIMIT = 6;

    public Lotto(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        lottoNumbers.getNumbers().stream().sorted();
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    private void validate(LottoNumbers lottoNumbers) {
        if(lottoNumbers.getNumbers().size() != SIZE_LIMIT){
            throw new RuntimeException("6개의 번호를 입력해주세요");
        }
    }
}
