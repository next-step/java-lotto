package lotto.domain;

import java.util.*;

public class LottoNumbers {
    public static final int CHOICE_COUNT = 6;
    public static final List<LottoNo> ALL_NUMBERS;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;

    static {
        ALL_NUMBERS = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            ALL_NUMBERS.add(LottoNo.of(i));
        }
    }

    private final List<LottoNo> lottoNos;

    public LottoNumbers(List<LottoNo> lottoNos) {
        validateCount(lottoNos);
        Collections.sort(lottoNos);
        this.lottoNos = lottoNos;
    }

    public LottoNumbers(int num1, int num2, int num3, int num4, int num5, int num6) {
        this(Arrays.asList(LottoNo.of(num1), LottoNo.of(num2), LottoNo.of(num3), LottoNo.of(num4), LottoNo.of(num5), LottoNo.of(num6)));
    }

    private void validateCount(List<LottoNo> lottoNos) {
        if (lottoNos.size() != CHOICE_COUNT) {
            throw new IllegalArgumentException("입력된 숫자 개수가 올바르지 않습니다.");
        }
    }

    public LottoNo find(int index) {
        return lottoNos.get(index);
    }

    public boolean contains(LottoNo number) {
        return lottoNos.contains(number);
    }

    public int countContains(LottoNumbers otherLottoNumbers) {
        int matchCount = 0;
        for (LottoNo number : otherLottoNumbers.lottoNos) {
            matchCount += contains(number) ? 1 : 0;
        }
        return matchCount;
    }

    public List<LottoNo> getValues() {
        return lottoNos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers lottoNumbers1 = (LottoNumbers) o;
        return Objects.equals(lottoNos, lottoNumbers1.lottoNos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNos);
    }
}
