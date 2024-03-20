package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public PickedLotto pickLotto() {
        Collections.shuffle(this.lottoNumbers);
        List<Integer> pickLottoNumbers = this.lottoNumbers.subList(0, 6);
        Collections.sort(pickLottoNumbers);
        return new PickedLotto(pickLottoNumbers);
    }
}
