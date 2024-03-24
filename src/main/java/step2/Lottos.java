package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public static Lottos buyLottos(int buyCount, NumberGenerator numberGenerator) {
        List<Lotto> lottosTemp = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            lottosTemp.add(new Lotto(numberGenerator));
        }
        return new Lottos(lottosTemp);
    }

    public static Lottos buyManualLottos(List<String> numbers, NumberGenerator numberGenerator) {
        List<Lotto> lottosTemp = new ArrayList<>();

        for (String number : numbers) {
            LottoNumbers lottoNumbers = new LottoNumbers(number);
            Lotto lotto = new Lotto(lottoNumbers, numberGenerator);
            lottosTemp.add(lotto);
        }

        return new Lottos(lottosTemp);
    }
}
