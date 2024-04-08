package lottopackage.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGroup {
    /* Member variable */
    private List<LottoTicket> lottoGroup = new ArrayList<>();

    /* Constructor */
    public LottoGroup(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            lottoGroup.add(new LottoTicket());
        }
    }

    public LottoGroup(List<LottoTicket> lottoGroup) {
        this.lottoGroup = lottoGroup;
    }

    /* Getter */
    public List<LottoTicket> getLottoGroup() {
        return lottoGroup;
    }

    /* Method */
    public List<Prize> isWinning(Set<Integer> winningNumber) {
        List<Prize> lottoResult = new ArrayList<>();
        for (int i = 0; i < lottoGroup.size(); i++) {
            LottoTicket lotto = lottoGroup.get(i);
            lottoResult.add(lotto.isPrize(winningNumber));
        }
        return lottoResult;
    }
}
