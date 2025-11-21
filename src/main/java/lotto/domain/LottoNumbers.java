package lotto.domain;

import lotto.domain.constant.LottoRank;

import java.util.Arrays;
import java.util.List;

public class LottoNumbers {

    private final List<NumberElement> numbers;

    public LottoNumbers(Integer[] numbers){
        this(Arrays.stream(numbers).map(NumberElement::new).toList());
    }

    public LottoNumbers(List<NumberElement> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    private static void validation(List<NumberElement> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 6개만 입력해주세요.");
        }
    }

    public LottoRank match(LottoNumber lottoNumber) {
        int count = 0;
        count = successCount(lottoNumber, count);
        return LottoRank.fromMatchCount(count);
    }

    public int successCount(LottoNumber useLotto, int count) {
        for (int j = 0; j < numbers.size(); j++) {
            if (isContains(useLotto, j)) {
                count++;
            }
        }
        return count;
    }

    public boolean isContains(LottoNumber useLotto, int index) {
        return this.numbers.contains(useLotto.getNumbers().numbers.get(index));
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
