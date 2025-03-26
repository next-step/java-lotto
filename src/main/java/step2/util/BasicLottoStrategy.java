package step2.util;

import step2.domain.LottoNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BasicLottoStrategy implements LottoStrategy {

    @Override
    public Set<LottoNum> generateLottoNumbers() {
        return toSet(pick(shuffle(generateNumbers())));
    }

    private List<LottoNum> generateNumbers() {
        List<LottoNum> selectNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            selectNumbers.add(new LottoNum(i));
        }
        return selectNumbers;
    }

    private List<LottoNum> shuffle(List<LottoNum> lottoNumbers) {
        List<LottoNum> lottoNums = new ArrayList<>(lottoNumbers);
        Collections.shuffle(lottoNums);
        return lottoNums;
    }

    private List<LottoNum> pick(List<LottoNum> lottoNumbers) {
        return lottoNumbers.subList(0, 6);
    }

    private Set<LottoNum> toSet(List<LottoNum> lottoNumbers) {
        return Set.copyOf(lottoNumbers);
    }
}
