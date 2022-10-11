package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumberList {

    private final List<LottoNumber> lottoNumberList;
    public static int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_EXCEPTION = "로또 번호는 " + LOTTO_SIZE + "개여야 합니다.";
    private static final String LOTTO_NUMBER_OVERLAP_EXCEPTION = "로또 번호는 중복 될 수 없습니다.";

    public static LottoNumberList createLottoNumbers(int[] ints) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : ints) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoNumberList(lottoNumbers);
    }

    public static LottoNumberList getLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : Numbers.getNumbers(LOTTO_SIZE)) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return new LottoNumberList(lottoNumbers);
    }

    public LottoNumberList(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_EXCEPTION);
        }
        if (isOverlap(lottoNumbers)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OVERLAP_EXCEPTION);
        }
        this.lottoNumberList = lottoNumbers;
    }

    public int match(LottoNumberList numbers) {
        return lottoNumberList.stream()
                .filter(lottoNumber -> numbers.lottoNumberList().contains(lottoNumber))
                .collect(Collectors.toList())
                .size();
    }

    private List<LottoNumber> lottoNumberList() {
        return Collections.unmodifiableList(this.lottoNumberList);
    }

    private boolean isOverlap(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberList that = (LottoNumberList) o;
        return Objects.equals(lottoNumberList, that.lottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumberList);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(lottoNumberList.get(0));
        for (int i = 1; i < lottoNumberList.size(); i++) {
            result.append(", ");
            result.append(lottoNumberList.get(i));
        }
        return result.toString();
    }
}
