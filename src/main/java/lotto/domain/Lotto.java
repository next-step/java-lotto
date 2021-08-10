package lotto.domain;

import java.util.*;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> lottoNumber;
    private final NumberGenerator numberGenerator;
    private Rank lottoRank;

    public Lotto(NumberGenerator numberGenerator) {
        this.numberGenerator  = numberGenerator;
        this.lottoNumber = createRandomNumbers();
        sortLottoNumbers();
    }

    private List<Integer> createRandomNumbers() {
        return numberGenerator.generateNumber();
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
    }

    public void matchLottoRank(WinningNumbers winningNumber) {
        long sameCount = lottoNumber.stream()
                .filter(integer -> winningNumber.getWinningNumbers()
                        .stream()
                        .anyMatch(Predicate.isEqual(integer)))
                .count();
        lottoRank = Rank.getRank(sameCount);
    }

    public Rank getRank() {
        return lottoRank;
    }
}
