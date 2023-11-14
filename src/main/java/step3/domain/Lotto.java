package step3.domain;

import java.util.List;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> list) {
        inputCheck(list);
        this.lottoNumbers = list;
    }

    private void inputCheck(List<LottoNumber> list) {
        if(list.stream().mapToInt(LottoNumber::number).distinct().count() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
