package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNo implements Comparable<LottoNo> {
    private final int number;
    private static final Map<Integer, LottoNo> lottoNumbers = new HashMap<>();

    static {
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.put(i, new LottoNo(i));
        }
    }

    private LottoNo(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("입력된 숫자 범위가 올바르지 않습니다.");
        }
    }

    public static LottoNo of(int number) {
        if (!lottoNumbers.containsKey(number)) {
            throw new IllegalArgumentException("입력된 숫자 범위가 올바르지 않습니다.");
        }
        return lottoNumbers.get(number);
    }

    public static List<LottoNo> toList(List<Integer> numbers) {
        List<LottoNo> LottoNos = new ArrayList<>();
        for (Integer number : numbers) {
            LottoNos.add(LottoNo.of(number));
        }
        return LottoNos;
    }

    public int getValue() {
        return number;
    }

    @Override
    public int compareTo(LottoNo o) {
        return Integer.compare(this.number, o.number);
    }
}
