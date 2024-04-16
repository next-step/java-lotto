package lottopackage.vo;

import lottopackage.domain.Prize;
import lottopackage.domain.WinningNumberAndBonusBall;
import lottopackage.vo.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private final List<Lotto> lottoGroup;

    public LottoGroup(int numberOfAutoLotto) {
        this(autoLotto(numberOfAutoLotto));
    }

    private static List<Lotto> autoLotto(int numberOfAutoLotto) {
        List<Lotto> autoLotto = new ArrayList<>();
        for (int i = 0; i < numberOfAutoLotto; i++) {
            autoLotto.add(new Lotto());
        }
        return autoLotto;
    }

    public LottoGroup(int numberOfLotto, List<Lotto> manualLotto) {
        this(autoLottoAndManualLotto(numberOfLotto, manualLotto));
    }

    public static List<Lotto> autoLottoAndManualLotto(int numberOfLotto, List<Lotto> manualLotto) {
        int numberOfAutoLotto = numberOfLotto - manualLotto.size();
        if ( numberOfAutoLotto < 0 ) {
            throw new IllegalArgumentException("수동 로또의 개수가 총 로또 개수보다 많을 수 없습니다.");
        }

        List<Lotto> autoLottoAndManualLotto = new ArrayList<>();
        autoLottoAndManualLotto.addAll(autoLotto(numberOfAutoLotto));
        autoLottoAndManualLotto.addAll(manualLotto);

        return autoLottoAndManualLotto;
    }

    public LottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    public List<Prize> checkPrize(WinningNumberAndBonusBall winningNumberAndBonusBall) {
        List<Prize> lottoResult = new ArrayList<>();
        for (int i = 0; i < lottoGroup.size(); i++) {
            Lotto lotto = lottoGroup.get(i);
            lottoResult.add(lotto.checkPrize(winningNumberAndBonusBall));
        }
        return lottoResult;
    }
}
