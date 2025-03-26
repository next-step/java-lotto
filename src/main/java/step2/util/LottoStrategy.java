package step2.util;

import step2.domain.LottoNum;

import java.util.Set;

public interface LottoStrategy {
    Set<LottoNum> generateLottoNumbers();
}
