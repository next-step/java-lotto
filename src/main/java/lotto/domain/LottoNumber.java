package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private final List<NumberElement> numbers;

    public LottoNumber(Integer... numbers) {
        this(Arrays.stream(numbers).map(NumberElement::new).collect(Collectors.toList()));
    }

    public LottoNumber(List<NumberElement> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    public LottoResult checkLottoNumber(List<LottoNumber> useLottoNumber) {
        LottoResult lottoResult = new LottoResult();

        for (LottoNumber lottoNumber : useLottoNumber) {
            lottoResult.putLottoResult(this.match(lottoNumber));
        }

        return lottoResult;
    }

    private LottoRank match(LottoNumber lottoNumber) {
        int count = 0;
        count = successCount(lottoNumber, count);
        return LottoRank.fromMatchCount(count);
    }


    private int successCount(LottoNumber useLotto, int count) {
        for (int j = 0; j < useLotto.numbers.size(); j++) {
            if (isContains(useLotto, j)) {
                count++;
            }
        }
        return count;
    }

    private boolean isContains(LottoNumber useLotto, int index) {
        return this.numbers.contains(useLotto.numbers.get(index));
    }

    private static void validation(List<NumberElement> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 6개만 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
