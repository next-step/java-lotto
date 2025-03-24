package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.Lotto;

public class LottoResult {

    private final List<Integer> lottoNumbers;

    public LottoResult(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public String display() {
        return this.lottoNumbers.toString();
    }

    public static List<LottoResult> from(List<Lotto> lottos) {
        return lottos
            .stream()
            .map(Lotto::toResult)
            .collect(Collectors.toList());
    }
}
