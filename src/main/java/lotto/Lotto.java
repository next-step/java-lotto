package lotto;

import java.util.*;

public class Lotto {
    public static final String IS_NOT_LOTTO_SIZE = "번호가 6개가 아닙니다.";
    private final List<Integer> lottoNumbers;

    public Lotto() {
        this(makeAutoLotto());
    }

    public Lotto(List<Integer> lottoNumbers) {
        validateLottoSetSize(lottoNumbers);
        this.lottoNumbers = makeSortLotto(lottoNumbers);
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
}
