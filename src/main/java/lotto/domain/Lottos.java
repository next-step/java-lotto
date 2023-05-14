package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final int LOTTO_AMOUNT_OF_MONEY = 1000;
    private final List<Lotto> lottos;

    public Lottos(int amount) {
        this(amount, Collections.emptyList());
    }

    public Lottos(int amount, List<String> manualLottoNumbers) {
        this.lottos = generateLottos(amount, manualLottoNumbers);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> generateLottos(int amount, List<String> manualLottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();

        for (String manualLottoNumber: manualLottoNumbers) {
            lottos.add(new Lotto(manualLottoNumber));
        }
        int autoLottosCount = amount / LOTTO_AMOUNT_OF_MONEY - manualLottoNumbers.size();

        for (int i = 0; i < autoLottosCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
