package lottopackage.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGroup {
    /* Member variable */
    private List<Lotto> lottoGroup = new ArrayList<>();

    /* Constructor */
    public LottoGroup(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            lottoGroup.add(new Lotto());
        }
    }

    public LottoGroup(List<Lotto> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    /* Getter */
    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }

    /* Method */
    public List<Prize> isWinning(Set<Integer> winningNumber) {
        List<Prize> lottoResult = new ArrayList<>();
        for (int i = 0; i < lottoGroup.size(); i++) {
            Lotto lotto = lottoGroup.get(i);
            lottoResult.add(lotto.isPrize(winningNumber));
        }
        return lottoResult;
    }
}
