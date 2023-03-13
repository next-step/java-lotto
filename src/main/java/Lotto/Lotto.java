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
        for (Integer lottoNubmer : lottoNumbers) {
            if(lottoNubmer < 1 || lottoNubmer > 45){
                throw new IllegalArgumentException("로또 번호는 1부터 45 까지 입니다");
            }
        }
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
        List<Integer> lottoNumber = IntStream.rangeClosed(1,45).boxed()
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumber);
        List<Integer> pickNumbers = lottoNumber.subList(0, 6);
        Collections.sort(pickNumbers);
        return pickNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void executeLotto(Lotto winLotto, int bonusNumber) {
        this.hitCount = winLotto.getLottoNumbers().stream()
                .filter(winLottoNumbers -> lottoNumbers.stream().anyMatch(Predicate.isEqual(winLottoNumbers)))
                .collect(Collectors.toList())
                .size();
        this.isBonusHit = lottoNumbers.contains(bonusNumber);
        this.rank = LottoRank.findRank(this.hitCount, this.isBonusHit);
    }

    public boolean getIsBonusHit() {
        return isBonusHit;
    }

    public void setRank() {

    }

    public LottoRank getRank() {
        return rank;
    }


    public int getHitCount() {
        return hitCount;
    }
}
