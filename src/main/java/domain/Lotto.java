package domain;

import java.util.List;
import java.util.Map;

import static domain.Rank.findRankBy;
import static util.CollectionCast.changeListToMap;
import static util.Validation.validateLottoNos;

public class Lotto {

    private Map<Integer, LottoNo> lottoNos;
    private Rank rank;

    public Lotto(List<LottoNo> numbers, Rank rank) {
        validateLottoNos(numbers);
        this.lottoNos.putAll(changeListToMap(numbers));
        this.rank = rank;
    }

    public Lotto(Rank rank) {
        this.rank = rank;
    }

    public Lotto(List<LottoNo> numbers) {
        validateLottoNos(numbers);
        this.lottoNos =changeListToMap(numbers);
    }

    public Lotto(NumberGenerator numberGenerator) {
        Map<Integer, LottoNo> integerLottoNoMap = generateAttemptNumbers(numberGenerator);
        this.lottoNos = integerLottoNoMap;
    }

    public Map<Integer, LottoNo> getLottoNos() {
        return lottoNos;
    }

    public Rank getRank() {
        return rank;
    }

    private Map<Integer, LottoNo> generateAttemptNumbers(NumberGenerator numberGenerator) {
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
