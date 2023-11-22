package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    public Lotto(List<LottoNumber> lottoNumbers) {
        validateDuplicate(lottoNumbers);
    }

    private static void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> nonDuplicateNumberList = new HashSet<>(lottoNumbers);
        if (nonDuplicateNumberList.size() < LOTTO_SIZE) {
            throw new IllegalArgumentException("중복된 숫자를 가징 수 없습니다.");
        }
    }
}
