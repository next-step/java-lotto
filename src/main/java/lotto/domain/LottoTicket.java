package lotto.domain;

import static lotto.util.Constant.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final int... numbers) {
        this(Arrays.stream(numbers).mapToObj(LottoNumber::from).collect(Collectors.toList()));
    }

    public LottoTicket(final List<LottoNumber> numbers) {
        lottoNumbers = getLottoNumbers(numbers);
    }

    private List<LottoNumber> getLottoNumbers(List<LottoNumber> numbers) {
        validateDuplicate(numbers);
        validateSize(numbers);
        return numbers;
    }

    private void validateDuplicate(List<LottoNumber> picked) {
        if (picked.size() != picked.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_ELEMENT);
        }
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int getMatchCount(LottoTicket winningNumbers) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
