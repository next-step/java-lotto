package domain;

import java.util.List;

import static domain.Rank.findRankBy;
import static util.Validation.validateLottoNos;

public class Attempt {

    private List<LottoNo> lottoNos;
    private Rank rank;

    public Attempt(List<LottoNo> numbers, Rank rank) {
        validateLottoNos(numbers);
        this.lottoNos = numbers;
        this.rank = rank;
    }

    public Attempt(Rank rank) {
        this.rank = rank;
    }

    public Attempt(List<LottoNo> numbers) {
        validateLottoNos(numbers);
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

    public void calculateRank(LottoWinningNo winningNo){
        this.rank = findRankBy(winningNo.calculateMatchCount(lottoNos), winningNo.isExistBonusNumber(lottoNos));
    }

    public static boolean isExistDuplicateNumber(List<LottoNo> numbers) {
        return numbers.stream()
                .map(LottoNo::getNumber)
                .distinct()
                .count() != numbers.size();
    }
}
