package lotto.domain;

import lotto.generator.LottoNumberGenerator;
import lotto.generator.RandomLottNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> values = new ArrayList<>();

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos of(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> newLottos = new ArrayList<>();
        newLottos.addAll(manualLottos.values);
        newLottos.addAll(autoLottos.values);
        return new Lottos(newLottos);
    }

    public static Lottos from(ManualLottos manualLottos) {
        List<Lotto> newLottos = new ArrayList<>();
        for (int i = 0; i < manualLottos.size(); i++) {
            newLottos.add(Lotto.from(manualLottos.getManualLotto(i)));
        }
        return new Lottos(newLottos);
    }

    public static Lottos from(int count) {
        List<Lotto> newLottos = new ArrayList<>();
        LottoNumberGenerator lottoNumberGenerator = new RandomLottNumberGenerator();
        for (int i = 0; i < count; i++) {
            newLottos.add(Lotto.from(lottoNumberGenerator.getLottoNumberList()));
        }
        return new Lottos(newLottos);
    }

    public int size() {
        return values.size();
    }

    public LottoResult match(WinningLotto winningLotto) {
        List<LottoPrize> result = new ArrayList<>();
        for (Lotto lotto : values) {
            result.add(LottoPrize.find(winningLotto.matchCount(lotto), winningLotto.matchBonus(lotto)));
        }
        return new LottoResult(result);
    }

    public String getLottoNumber(int index) {
        return values.get(index).toString();
    }
}
