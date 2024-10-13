package lotto.domain;

import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;

import java.util.*;

public class Lotto {
    private static final String IS_NOT_LOTTO_SIZE = "번호가 6개가 아닙니다.";
    private static final String INPUT_IS_NOT_NUMBER = "입력된 값이 숫자가 아닙니다.";
    private static final String IS_NOT_LOTTO_NUMBER = "로또번호가 1~45가 아닙니다.";
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private static final String IS_DUPLICATE_NUMBER = "중복된 번호가 있습니다.";
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoSetSize(lottoNumbers);
        this.lottoNumbers = makeSortLotto(lottoNumbers);
    }

    public Lotto(String[] inputNumbers) {
        this(splitInput(inputNumbers));
    }

    public static List<Integer> splitInput(String[] inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : inputNumbers) {
            numbers.add(convertStringToInt(number));
        }
        return numbers;
    }

    private static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }


    private List<Integer> makeSortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validateLottoNumbers(numbers);
        return numbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.get(5) > LOTTO_MAX_NUM) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_NUMBER);
        }
        if (numbers.get(0) < LOTTO_MIN_NUM) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_NUMBER);
        }
    }

    private void validateLottoSetSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoRank getLottoResult(WinningLotto winningLotto) {
        int equalCount = 0;
        List<Integer> winningLottoNumbers = winningLotto.getWinningLotto();
        for (int number : winningLottoNumbers) {
            equalCount += addCount(number);
        }
        return getRank(equalCount, winningLotto.getBonusNumber());
    }

    private int addCount(int winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    private LottoRank getRank(int equalCount, int bonusNumber) {
        LottoRank lottoRank = LottoRank.matchRank(equalCount);
        if (lottoRank.equals(SECOND)) {
            return isSecondRank(bonusNumber);
        }
        return lottoRank;
    }

    private LottoRank isSecondRank(int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return SECOND;
        }
        return THIRD;
    }

    public void validateDuplicate(int number) {
        if (lottoNumbers.contains(number)) {
            throw new IllegalArgumentException(IS_DUPLICATE_NUMBER);
        }
    }
}
