package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public List<Integer> lottoGenerate() {
        List<Integer> lottoNumbers =  initialLottoRange();
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0,6);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> initialLottoRange() {
        return IntStream.range(1,46).boxed().collect(Collectors.toList());
    }
}
