package autoLotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static autoLotto.model.LottoConstants.*;

public class LottoWinChecker {
    private static final String INVALID_WIN_NUMBERS = "당첨 번호의 개수는 0 ~ 6개이며, 각 번호는 1 이상 45 이하의 값만 가능합니다.";

    private HashMap<Integer, Integer> winLottos;

    public LottoWinChecker(String winNumbersAsString, List<Lotto> lottos) {
        this.winLottos = createWinLotto(winNumbersAsString, lottos);
    }

    private HashMap<Integer, Integer> createWinLotto(String winNumbersAsString, List<Lotto> lottos) {
        List<Integer> winLotto = retrieveWinLotto(winNumbersAsString);
        if (!isValidWinNumbersSize(winLotto) || !isValidWinNumbers(winLotto)) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBERS);
        }
        return countWinLotto(winLotto, lottos);
    }

    private List<Integer> retrieveWinLotto(String winNumbersInString) {
        Lotto lotto = new Lotto(winNumbersInString);
        return lotto.getLotto();
    }

    private boolean isValidWinNumbersSize(List<Integer> winLotto) {
        if (winLotto.size() != VALID_LOTTO_LENGTH) {
            return false;
        }

        return true;
    }

    private boolean isValidWinNumbers(List<Integer> winLotto) {
        Collections.sort(winLotto);
        return isNumberInValidRange(winLotto.get(0)) && isNumberInValidRange(winLotto.get(VALID_LOTTO_LENGTH - 1));
    }

    private boolean isNumberInValidRange(int number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

    private HashMap<Integer, Integer> countWinLotto(List<Integer> winLotto, List<Lotto> lottos) {
        HashMap<Integer, Integer> result = new HashMap<>();

        for (Lotto lotto : lottos) {
            int countOfWinNumbers = compareWinNumbers(winLotto, lotto);
            saveOnlyPrize(result, countOfWinNumbers);
        }

        return result;
    }

    private int compareWinNumbers(List<Integer> winLotto, Lotto lotto) {
        List<Integer> targetLotto = lotto.getLotto();
        int matchingNumbers = 0;

        for (int number : targetLotto) {
            matchingNumbers += hasWinNumber(winLotto, number);
        }

        return matchingNumbers;
    }

    private void saveOnlyPrize(HashMap<Integer, Integer> result, int countOfWinNumbers) {
        if (countOfWinNumbers < PrizeResultEnum.THREE_MATCHED.getIndex()) {
            return;
        }

        result.put(countOfWinNumbers, result.getOrDefault(countOfWinNumbers, 0) + 1);
    }

    private int hasWinNumber(List<Integer> winLotto, int targetNumber) {
        if(winLotto.contains(targetNumber)) {
            return 1;
        }

        return 0;
    }

    public HashMap<Integer, Integer> getWinLottos() {
        return this.winLottos;
    }
}
