package lotto.domain.lotto;

import lotto.domain.lotto.util.LottoUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoBundle {

    private final List<Lotto> lottoList;

    public ManualLottoBundle(List<String> answerStrings) {
        List<Lotto> lottoList = answerStrings.stream()
                .map(string -> convertToLotto(string))
                .collect(Collectors.toList());
        this.lottoList = lottoList;
    }

    private Lotto convertToLotto(String stringNumbers) {
        return LottoUtil.stringsToLotto(stringNumbers);
    }

    public List<Lotto> unfoldLottoBundle() {
        return List.copyOf(this.lottoList);
    }

}
