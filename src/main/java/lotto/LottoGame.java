package lotto;

import java.util.List;

public class LottoGame {

    public static final int LOTTO_PICK_NUMBERS = 6;

    private final List<LottoNumber> numbers;

    public LottoGame(List<LottoNumber> numbers) {
        this.numbers = numbers;

        validateNumbers();
    }

    public void validateNumbers() {
        if (numbers.size() != LOTTO_PICK_NUMBERS) {
            throw new IllegalArgumentException("choose " + LOTTO_PICK_NUMBERS + " numbers");
        }

        if (numbers.stream().anyMatch(n -> !n.isValidNumber())) {
            throw new IllegalArgumentException("invalid number range");
        }

        if (!Utils.isUnique(numbers)) {
            throw new IllegalArgumentException("numbers are not unique");
        }
    }

    public LottoPlace getMatchedPlace(LottoGame lottoGame) {
        int matchedSize = Utils.getIntersection(lottoGame.numbers, numbers).size();

        return LottoPlace.findByNumMatchedOrNone(matchedSize);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

}
