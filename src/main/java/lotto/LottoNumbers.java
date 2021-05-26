package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        if (!isValidSource(numbers)) {
            throw new IllegalArgumentException("lotto는 6개의 숫자로 구성되어 있습니다");
        }
        lottoNumbers = numbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    public boolean isComplete() {
        return lottoNumbers.size() == LOTTO_SIZE;
    }

    public boolean hasWinLottoNumber(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        StringBuffer lottoMessage = new StringBuffer("[");
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoMessage.append(lottoNumbers.get(i).toString());
            if (i == LOTTO_SIZE - 1) {
                break;
            }
            lottoMessage.append(", ");
        }
        lottoMessage.append("]");
        return lottoMessage.toString();
    }

    public int sameCount(LottoNumbers pursedLotto) {
        int result = 0;
        for (LottoNumber number : pursedLotto.lottoNumbers) {
            result = compareToPurchased(number, result);
        }
        return result;
    }

    private int compareToPurchased(LottoNumber purchased, int count) {
        if (contains(purchased)) {
            count++;
        }
        return count++;
    }

    protected boolean contains(LottoNumber purchased) {
        return lottoNumbers.contains(purchased);
    }

    private boolean isValidSource(List<Integer> numbers) {
        return numbers.size() == LOTTO_SIZE;
    }
}
