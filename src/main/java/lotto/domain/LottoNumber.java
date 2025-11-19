package lotto.domain;

import java.util.List;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(Integer... numbers) {
        this(List.of(numbers));
    }

    public LottoNumber(List<Integer> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    public LottoResult checkLottoNumber(List<LottoNumber> useLottoNumber) {
        LottoResult lottoResult = new LottoResult();

        for (LottoNumber lottoNumber : useLottoNumber) {
            int count = 0;

            count = successCount(lottoNumber, count);

            LottoRank lottoRank = LottoRank.fromMatchCount(count);

            lottoResult.putLottoResult(lottoRank);
        }

        return lottoResult;
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
        return numbers.contains(useLotto.numbers.get(index));
    }

    private static void validation(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("지난 주 당첨 번호는 6개만 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
