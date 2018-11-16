package domain;

import java.util.List;

import static domain.Rank.findRankBy;
import static util.Validation.validateLottoNos;

public class Lotto {

    private List<LottoNo> lottoNos;
    private Rank rank;

    private Lotto(List<LottoNo> numbers, Rank rank) {
        validateLottoNos(numbers);
        this.lottoNos = numbers;
        this.rank = rank;
    }

    private Lotto(Rank rank) {
        this.rank = rank;
    }

    private Lotto(List<LottoNo> numbers) {
        validateLottoNos(numbers);
        this.lottoNos = numbers;
    }

    public static Lotto from(Rank rank) {
        return new Lotto(rank);
    }

    public static Lotto from(List<LottoNo> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto from(List<LottoNo> numbers, Rank rank) {
        return new Lotto(numbers, rank);
    }

    public Lotto(NumberGenerator numberGenerator) {
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

    public void calculateRank(LottoWinning winningNo){
        this.rank = findRankBy(winningNo.calculateMatchCount(lottoNos), winningNo.isExistBonusNumber(lottoNos));
    }

    public static boolean isExistDuplicateNumber(List<LottoNo> numbers) {
        return numbers.stream()
                .map(LottoNo::getNumber)
                .distinct()
                .count() != numbers.size();
    }
}
