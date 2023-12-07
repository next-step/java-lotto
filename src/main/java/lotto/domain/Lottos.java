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

    public static Lottos from(LottoBuyInfo buyInfo, ManualLottos manualLottos) {
        List<Lotto> newLottos = new ArrayList<>();
        LottoNumberGenerator lottoNumberGenerator = new RandomLottNumberGenerator();
        for (int i = 0; i < manualLottos.size(); i++) {
            newLottos.add(Lotto.from(manualLottos.getManualLotto(i)));
        }
        for (int i = 0; i < buyInfo.getAutoCount(); i++) {
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
