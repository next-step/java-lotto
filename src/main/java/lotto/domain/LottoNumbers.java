package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    public static final int DEFAULT_QUANTITY = 6;
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(List<Integer> numbers) {
        this.lottoNumbers = new HashSet<>();
        for(int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        validateSize(lottoNumbers);
    }

    private static void validateSize(Set<LottoNumber> numbers) {
        if (isSizeNotEqualsSix(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSizeNotEqualsSix(Set<LottoNumber> numbers) {
        return numbers == null || numbers.size() != DEFAULT_QUANTITY;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int matchedCount(Lotto lotto) {
        int count = 0;
        for(LottoNumber lottoNumber : lottoNumbers) {
            if(lotto.contains(lottoNumber)) count++;
        }

        return count;
    }
}
