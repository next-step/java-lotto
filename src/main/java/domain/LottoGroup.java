package domain;

import domain.wrapper.Money;
import utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private static final int COMBINE_MIN_NUM = 3;
    private static final int LOTTO_CHOICE_CNT = 6;

    private List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottoGroup) {
        if (lottoGroup == null) {
            throw new NullPointerException();
        }
        this.lottoGroup = lottoGroup;
    }

    public LottoGroup(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateNumberList(LOTTO_CHOICE_CNT));
            lottos.add(lotto);
        }
        this.lottoGroup = lottos;
    }

    public LottoGroup(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        manualLottos.addAll(autoLottos);
        this.lottoGroup = manualLottos;
    }

    public LottoGroup(LottoGroup manualLottoGroup, LottoGroup autoLottoGroup) {
        this.lottoGroup = manualLottoGroup.getLottoGroup();
        lottoGroup.addAll(autoLottoGroup.getLottoGroup());
    }

    public LottoGroup(Money myMoney) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < myMoney.getCount(); i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateNumberList(LOTTO_CHOICE_CNT));
            lottos.add(lotto);
        }
        this.lottoGroup = lottos;
    }

    public int getSize() {
        return lottoGroup.size();
    }

    public LottoResultGroup getCombineLottos(WinningLotto lastLotto) {
        List<LottoResult> winningLottos = new ArrayList<>();

        for (Lotto lotto : lottoGroup) {
            if (lastLotto.getCombineCount(lotto) > COMBINE_MIN_NUM) {
                winningLottos.add(lastLotto.getCombineNumbers(lotto));
            }
        }
        return new LottoResultGroup(winningLottos);
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }
}
