package lotto.domain;

import lotto.util.NumberUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private final static int size = 6;
    private Set<LottoNumber> lottoNumbers;

    public Lotto() {
        lottoNumbers = generateRandomNumbersSet();
    }

    protected Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto createLotto() {
        selectedNumber(generateRandomNumbersSet());
        return this;
    }

    public int numberOfLottoCount() {
        return this.lottoNumbers.size();
    }

    protected Lotto selectedNumber(Set<LottoNumber> randomNumbers) {
        this.lottoNumbers = randomNumbers;
        return this;
    }

    public boolean checkBonusNumber(BonusNumber bonusNumber) {
        LottoNumber bonuslottoNumber = bonusNumber.getLottoNumber();
        boolean containsBonusNumber = this.lottoNumbers.contains(bonuslottoNumber);
        return containsBonusNumber;
    }

    protected Set<LottoNumber> generateRandomNumbersSet() {
        List<Integer> randomNumbers = NumberUtil.getLottoNumbers();

        Collections.shuffle(randomNumbers);

        Set<LottoNumber> lottoNumberSet = randomNumbers.subList(0, size).stream()
                .map(LottoNumber::new).collect(Collectors.toSet());
        return lottoNumberSet;
    }

    protected int checkLastWinningNumberSet(String lastWinningNumber) {
        Set<LottoNumber> winnerNumbers = NumberUtil.convertStringToIntegerList(lastWinningNumber).stream()
                .map(LottoNumber::new).collect(Collectors.toSet());
        int matchCount = compareMatchCount(winnerNumbers);

        return matchCount;
    }

    private int compareMatchCount(Set<LottoNumber> winnerNumbers) {
        int matchNumber = 0;
        Iterator<LottoNumber> iterator = winnerNumbers.iterator();
        while (iterator.hasNext()) {
            LottoNumber lastWinninglottoNumber = iterator.next();
            matchNumber = matchNumber + containNumber(lastWinninglottoNumber);
        }
        ;
        return matchNumber;
    }

    private int containNumber(LottoNumber lastWinninglottoNumber) {
        boolean contains = this.lottoNumbers.contains(lastWinninglottoNumber);
        if (contains) {
            return 1;
        }
        return 0;
    }

    public HashSet<LottoNumber> showLottoNumber() {
        return new HashSet<>(this.lottoNumbers);
    }
}
