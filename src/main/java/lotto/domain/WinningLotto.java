package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.util.Pair;
import lotto.utils.NumberStrategy;

public class WinningLotto extends Lotto {

    private final int bonusBall;

    public WinningLotto(NumberStrategy numberStrategy, int bonusBall) {
        super(numberStrategy);
        super.checkNumber(bonusBall);
        this.bonusBall = bonusBall;
    }

    public List<Pair<Integer, Boolean>> matchResult(List<Lotto> lottos) {
        List<Pair<Integer, Boolean>> result = matchCounts(lottos);
        Collections.sort(result, Comparator.comparing(p -> p.getKey()));
        return result;
    }

    public List<Pair<Integer, Boolean>> matchCounts(List<Lotto> lottos) {
        List<Pair<Integer, Boolean>> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(new Pair<>(matchCount(lotto), matchBonusBall(lotto)));
        }
        return result;
    }

    private int matchCount(Lotto lotto) {
        int matchNumber = 0;
        for (int i = 0; i < lotto.getLottoNumber().size(); i++) {
            matchNumber += checkMatch(lotto.getLottoNumber(), i);
        }
        return matchNumber;
    }

    private boolean matchBonusBall(Lotto lotto) {
        return lotto.getLottoNumber().contains(bonusBall);
    }

    private int checkMatch(List<Integer> lottoNumber, int num) {
        return super.getLottoNumber().contains(lottoNumber.get(num)) ? 1 : 0;
    }

}
