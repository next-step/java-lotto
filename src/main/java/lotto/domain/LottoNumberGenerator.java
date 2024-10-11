package lotto.domain;

import java.util.List;

public interface LottoNumberGenerator {
    public List<List<Integer>> genLottoNumbers(int cnt);
}
