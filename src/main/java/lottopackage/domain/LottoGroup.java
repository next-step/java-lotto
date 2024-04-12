package lottopackage.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    private List<Lotto> lottoGroup = new ArrayList<>();

    public LottoGroup(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            lottoGroup.add(new Lotto());
        }
    }

    public LottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    public List<Prize> checkPrize(WinningNumber winningNumber) {
        List<Prize> lottoResult = new ArrayList<>();
        for (int i = 0; i < lottoGroup.size(); i++) {
            Lotto lotto = lottoGroup.get(i);
            lottoResult.add(lotto.checkPrize(winningNumber));
        }
        return lottoResult;
    }
}
