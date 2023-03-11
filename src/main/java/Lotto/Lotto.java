package Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        IntStream intStream = IntStream.rangeClosed(1,45);
        Stream<Integer> stream = intStream.boxed();
        List<Integer> numbers = stream.collect(Collectors.toList());
        Collections.shuffle(numbers);
        List<Integer> pickNumbers = numbers.subList(0, 6);
        Collections.sort(pickNumbers);
        return pickNumbers;
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

    public void setRank() {
        this.rank = LottoRank.findRank(this.hitCount, this.isBonusHit);
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
