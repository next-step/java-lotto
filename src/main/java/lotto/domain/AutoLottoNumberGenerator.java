package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generateLottoNumber(List<Integer> lottoNumbers, int lottoCount) {
        List<Integer> copyList = new ArrayList<>(lottoNumbers);
        Collections.shuffle(copyList);
        return copyList.subList(0, lottoCount);
    }
}
