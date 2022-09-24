package lotto.step2;

import java.util.List;

public interface ShuffleStrategy {
    List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers);
}
