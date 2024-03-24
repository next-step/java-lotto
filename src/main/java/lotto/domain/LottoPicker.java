package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPicker {
    private final List<Integer> lottoNumbers;

    public LottoPicker() {
        this.lottoNumbers = IntStream.rangeClosed(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    public LottoNumbers pickLotto() {
        Collections.shuffle(this.lottoNumbers);
        List<Integer> pickLottoNumbers = new ArrayList<>(this.lottoNumbers.subList(0, 6));
        Collections.sort(pickLottoNumbers);
        return new LottoNumbers(pickLottoNumbers);
    }
}
