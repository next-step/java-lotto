package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Rank.*;

public class Attempt {

    private List<LottoNo> lottoNos;
    private Rank rank;

    public Attempt(List<LottoNo> numbers, Rank rank) {
        this.lottoNos = numbers;
        this.rank = rank;
    }

    public Attempt(List<LottoNo> numbers) {
        this.lottoNos = numbers;
    }

    public Attempt(NumberGenerator numberGenerator) {
        this.lottoNos = generateAttemptNumbers(numberGenerator);
    }

    public List<LottoNo> getLottoNos() {
        return lottoNos;
    }

    public Rank getRank() {
        return rank;
    }

    private List<LottoNo> generateAttemptNumbers(NumberGenerator numberGenerator) {
        return numberGenerator.getRandomNumber();
    }

    public void calculateRank(List<LottoNo> numbers, int bonusNumber){
        setRank(calculateMatchCount(numbers), isExistBonusNumber(bonusNumber));
    }

    public int calculateMatchCount(List<LottoNo> numbers) {
        return calculateMatchNumbers(numbers).size();
    }

    private List<LottoNo> calculateMatchNumbers(List<LottoNo> winnerNumbers) {
        List<LottoNo> matchNumbers = new ArrayList<>();

        for (LottoNo number : lottoNos) {
            if (isContainSameNumber(winnerNumbers, number.getNumber())) {
                matchNumbers.add(number);
            }
        }
        return matchNumbers;
    }

    private boolean isExistBonusNumber(int numbers) {
        return isContainSameNumber(lottoNos, numbers);
    }

    public void setRank(int matchCount, boolean bonusYn) {
        this.rank = findRankBy(matchCount, bonusYn);
    }

    public static boolean isContainSameNumber(List<LottoNo> numbers, int bonusNumber) {
        return numbers.stream()
                .filter(lottoNo -> lottoNo.getNumber() == bonusNumber)
                .count() > 0;
    }
}
