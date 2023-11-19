package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public Lotto(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
    }

    private static void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateNumberList = new HashSet<>(lottoNumbers);
        if(nonDuplicateNumberList.size() < 6) {
            throw new IllegalArgumentException("중복된 숫자를 가질 수 없습니다.");
        }
    }
}
