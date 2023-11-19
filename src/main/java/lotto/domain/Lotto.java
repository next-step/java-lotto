package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_MAX_SIZE = 6;
    private List<LottoNumber> lotto;
    public Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.lotto = lottoNumbers;
    }

    private static void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() < LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("로또 사이즈는 6보다 작을 수 없습니다.");
        }
    }

    private static void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateNumberList = new HashSet<>(lottoNumbers);
        if(nonDuplicateNumberList.size() < LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("중복된 숫자를 가질 수 없습니다.");
        }
    }
}
