package lotto.domain;

import java.util.*;

public class Lotto {
    public static final String IS_NOT_LOTTO_SIZE = "번호가 6개가 아닙니다.";
    public static final String BLINK_INPUT_ERROR = "입력된 값이 없습니다.";
    public static final String INPUT_IS_NOT_NUMBER = "입력된 값이 숫자가 아닙니다.";
    private static final String DELIMETER = ",";
    private final List<Integer> lottoNumbers;

    public Lotto() {
        this(makeAutoLotto());
    }

    public Lotto(String input) {
        List<Integer> lotto = splitInput(input);
        validateLottoSetSize(lotto);
        this.lottoNumbers = makeSortLotto(lotto);
    }

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoSetSize(lottoNumbers);
        this.lottoNumbers = makeSortLotto(lottoNumbers);
    }

    public List<Integer> splitInput(String input) {
        validateNotNull(input);
        String[] stringNumbers = input.split(DELIMETER);

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers.add(convertStringToInt(stringNumbers[i]));
        }
        return numbers;
    }

    private int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(INPUT_IS_NOT_NUMBER);
        }
    }

    private static void validateNotNull(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }

    private static List<Integer> makeAutoLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    private static List<Integer> makeSortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private void validateLottoSetSize(List<Integer> lottoSet) {
        if (lottoSet.size() != 6) {
            throw new IllegalArgumentException(IS_NOT_LOTTO_SIZE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getLottoResult(Lotto winningLotto) {
        int equalCount = 0;
        List<Integer> winningLottoNumbers = winningLotto.getLottoNumbers();
        for (int i = 0; i < winningLottoNumbers.size(); i++) {
            equalCount += addCount(winningLottoNumbers.get(i));
        }
        return getRank(equalCount);
    }

    private int addCount(int winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    private int getRank(int equalCount) {
        if (equalCount == 6) {
            return 1;
        }
        if (equalCount == 5) {
            return 3;
        }
        if (equalCount == 4) {
            return 4;
        }
        if (equalCount == 3) {
            return 5;
        }
        return 6;
    }
}
