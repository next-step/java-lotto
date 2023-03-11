package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {

    private String lottoType = "";
    private final List<Integer> lottoNumbers;
    private LottoRank rank;
    private int hitCount = 0;
    private boolean isBonusHit = false;

    protected Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createAutoLotto() {
        List<Integer> lottoNumbers = makeLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    public static Lotto createManualLotto(List<Integer> manualLottoNumbers) {
        return new Lotto(manualLottoNumbers);
    }

    public static List<Integer> makeLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }


    public void setIsBonusHit(int bonusHit) {
        this.isBonusHit = lottoNumbers.contains(bonusHit);
    }

    public boolean getIsBonusHit() {
        return isBonusHit;
    }

    public void setRank(LottoRank rank) {
        this.rank = rank;
    }

    public LottoRank getRank() {
        return rank;
    }

    public void setHitCount(Lotto winLotto) {
        List<Integer> hitList = winLotto.getLottoNumbers().stream()
                .filter(o -> lottoNumbers.stream().anyMatch(Predicate.isEqual(o)))
                .collect(Collectors.toList());
        this.hitCount = hitList.size();
    }

    public int getHitCount() {
        return hitCount;
    }
}
