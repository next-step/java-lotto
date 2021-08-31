package lotto.domain;

import java.util.List;

public interface GenerateNumStrategy {
    Lottos generate(int totalLottoNum, int numsPerLotto);
}
