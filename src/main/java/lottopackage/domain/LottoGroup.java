package lottopackage.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGroup {
    List<Lotto> lottoGroup = new ArrayList<>();

    public LottoGroup(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            lottoGroup.add(new Lotto());
        }
    }

    public List<Prize> isWining(List<Integer> winningNumber) {
        List<Prize> lottoResult = new ArrayList<>();
        for (int i = 0; i < lottoGroup.size(); i++ ) {
            lottoResult.add( lottoGroup.get(i).isPrize(winningNumber) );
        }
        return lottoResult;
    }
}
