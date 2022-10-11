package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<LottoNumber> lottoNumberList;

    private LottoNumbers(List<LottoNumber> lottoNumberList) {
        this.lottoNumberList = lottoNumberList;
    }

    public static LottoNumbers of(List<LottoNumber> lottoNumberList) {
        valid(lottoNumberList);
        return new LottoNumbers(lottoNumberList);
    }

    public int matches(LottoNumbers numbers) {
        return (int) numbers.lottoNumberList.stream()
            .filter(lottoNumberList::contains)
            .count();
    }

    private static boolean isDuplicate(List<LottoNumber> lottoNumbers) {
        int count = (int) lottoNumbers.stream()
            .distinct()
            .count();

        return count != LOTTO_NUMBER_SIZE;
    }

    private static void valid(List<LottoNumber> lottoNumberList) {
        if (isDuplicate(lottoNumberList)) {
            throw new IllegalArgumentException("번호는 중복될 수 없습니다.");
        }
    }

    public int size() {
        return this.lottoNumberList.size();
    }

    @Override
    public String toString() {
        return lottoNumberList.toString();
    }
}
