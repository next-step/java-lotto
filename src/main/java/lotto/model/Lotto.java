package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(List<Integer> lottoNumbers) {
        validate(lottoNumbers);
        for (Integer lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }
    }

    private void validate(List<Integer> lottoNumbers) {
        if(lottoNumbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또의 개수가 맞지 않습니다.");
        }
        if(new HashSet<Integer>(lottoNumbers).size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또의 번호가 중복되었습니다.");
        }
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return lotto.equals(lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
