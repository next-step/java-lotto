package step3.domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> list) {
        inputValidation(list);
        this.lottoNumbers = list;
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }

    private void inputValidation(List<LottoNumber> list) {
        if(list.stream().mapToInt(LottoNumber::number).distinct().count() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        if(list.stream().mapToInt(LottoNumber::number).count() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

}
