package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Lotto> generateLottoNumber(List<Lotto> lottos, int lottoCount) {
        List<Integer> allNumbers = lottos.stream()
                .map(lottoNumber -> lottoNumber.getNumber())
                .collect(Collectors.toList());
        List<Integer> copyList = new ArrayList<>(allNumbers);
        Collections.shuffle(copyList);
        copyList = copyList.subList(0, lottoCount);
        return copyList.stream()
                .map(element -> new Lotto(element))
                .collect(Collectors.toList());
    }
}
