package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private final Lottos lottos;

    public static LottoResult of(Lottos lottos) {
        return new LottoResult(lottos);
    }

    public LottoResult(Lottos lottos) {
        this.lottos = lottos;
    }

    public List<String> lottoInfos() {
        List<String> result = new ArrayList<>();

        lottos.values().forEach(lotto -> {
            result.add(createLottoInfo(lotto));
        });

        return result;
    }

    private String createLottoInfo(Lotto lotto) {
        List<String> lottoStringNumbers = getStringNumbers(lotto);
        return "[ " + String.join(", ", lottoStringNumbers) + " ]";
    }

    private static List<String> getStringNumbers(Lotto lotto) {
        return lotto.lottoStringNumbers();
    }

    public Lottos lottos() {
        return lottos;
    }

    public int quantity() {
        return lottos.quantity();
    }
}
