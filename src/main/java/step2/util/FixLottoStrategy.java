package step2.util;

import step2.domain.LottoNum;

import java.util.Set;

public class FixLottoStrategy implements LottoStrategy{

    private final Set<LottoNum> fixLottoNumber;

    public FixLottoStrategy(Set<LottoNum> fixLottoNumber) {
        this.fixLottoNumber = Set.copyOf(fixLottoNumber);
    }

    @Override
    public Set<LottoNum> generateLottoNumbers() {
        return fixLottoNumber;
    }
}
