package lotto.domain;

import static lotto.util.Constant.*;

import java.util.Iterator;
import java.util.List;

public class LottoTicket implements Iterable<Integer> {

    private final List<Integer> lottoNumbers;

    public LottoTicket(List<Integer> numbers) {
        lottoNumbers = getLottoNumbers(numbers);
    }

    private List<Integer> getLottoNumbers(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateSize(numbers);
        return numbers;
    }

    private void validateDuplicate(List<Integer> picked) {
        if (picked.size() != picked.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 요소가 있습니다! 예외 발생시키기");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("[ERROR] 티켓의 사이즈가 올바르지 않습니다! 예외 발생시키기");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return lottoNumbers.iterator();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int getMatchCount(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean contains(int value) {
        return lottoNumbers.contains(value);
    }
}
