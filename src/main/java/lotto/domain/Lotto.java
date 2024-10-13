package lotto.domain;

import java.util.*;

public class Lotto {
    private static final List<Integer> lottoNumbersPool = new ArrayList<>();

    static {
        for (int i = 1; i <= 45; i++) {
            lottoNumbersPool.add(i);
        }
    }

    private static final String IS_NOT_LOTTO_SIZE = "번호가 6개가 아닙니다.";
    private static final String INPUT_IS_NOT_NUMBER = "입력된 값이 숫자가 아닙니다.";
    private static final String IS_NOT_LOTTO_NUMBER = "로또번호가 1~45가 아닙니다.";
    private static final int LOTTO_MIN_NUM = 1;
    private static final int LOTTO_MAX_NUM = 45;
    private final List<Integer> lottoNumbers;

    public static Lotto autoLotto() {
        return new Lotto(makeAutoLotto());
    }

    public Lotto(String[] inputNumbers) {
        this(splitInput(inputNumbers));
    }

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoSetSize(lottoNumbers);
        this.lottoNumbers = makeSortLotto(lottoNumbers);
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

    private static List<Integer> makeAutoLotto() {
        List<Integer> numbers = new ArrayList<>(lottoNumbersPool);
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    private static List<Integer> makeSortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        validateLottoNumbers(numbers);
        return numbers;
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
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

    public LottoRank getLottoResult(Lotto winningLotto) {
        int equalCount = 0;
        List<Integer> winningLottoNumbers = winningLotto.getLottoNumbers();
        for (int number : winningLottoNumbers) {
            equalCount += addCount(number);
        }
        return getRank(equalCount);
    }

    private int addCount(int winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    private LottoRank getRank(int equalCount) {
        return LottoRank.matchRank(equalCount);
    }
}
