package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private Lottos lottos;

    public static LottoResult of(Lottos lottos) {
        return new LottoResult(lottos);
    }

    public LottoResult(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<String> lottos() {
        List<String> result = new ArrayList<>();

        lottos.values().forEach(lotto -> {
            result.add(createLottoInfo(lotto));
        });

        return result;
    }

    public String createLottoInfo(Lotto lotto) {
        List<String> lottoStringNumbers = getStringNumbers(lotto);
        return "[ " + String.join(", ", lottoStringNumbers) + " ]";
    }

    private static List<String> getStringNumbers(Lotto lotto) {
        return lotto.lottoNumbers()
                .stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.number()))
                .collect(Collectors.toList());
    }

    public int quantity() {
        return lottos.quantity();
    }
}
