package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;


    public Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);

        if (new HashSet<>(lottoNumbers).size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여아한다.");
        }
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException("로또 번호는 1~45 사이여야한다.");
            }
        }
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
