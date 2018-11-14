package domain;

import domain.wrapper.Money;
import utils.LottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static domain.Lotto.LOTTO_CHOICE_CNT;

public class LottoGroup {
    private static final int COMBINE_MIN_NUM = 3;

    private List<Lotto> lottoGroup;

    public LottoGroup(List<Lotto> lottoGroup) {
        if (lottoGroup == null) {
            throw new NullPointerException();
        }
        if (lottoGroup.size() < 0) {
            throw new IllegalArgumentException("배열이 없습니다.");
        }
        this.lottoGroup = lottoGroup;
    }

    public LottoGroup(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = LottoGenerator.generateNumberList(LOTTO_CHOICE_CNT);
            lottos.add(lotto);
        }
        this.lottoGroup = lottos;
    }

    public LottoGroup(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        Optional.ofNullable(manualLottos).orElse(new ArrayList<>());
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
            Lotto lotto = LottoGenerator.generateNumberList(LOTTO_CHOICE_CNT);
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
