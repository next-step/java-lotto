package lotto.domain.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

final class LottoNo {
    public static final String ERROR_MESSAGE_UNEXPECTED_RANGE_NUMBER = "로또번호는 1 ~ 45까지의 숫자 입니다.";
    public static final int START_LOTTO_NO = 1;
    public static final int END_LOTTO_NO = 45;
    private static final Set<LottoNo> cached;
    static {
        final Set<LottoNo> lottoNos = IntStream.rangeClosed(START_LOTTO_NO, END_LOTTO_NO)
                                               .mapToObj(LottoNo::new)
                                               .collect(Collectors.toCollection(LinkedHashSet::new))
            ;
        cached = Collections.unmodifiableSet(lottoNos);
    }

    private static final LottoNo empty = new LottoNo(0);

    private final int lottoNo;

    private LottoNo(int lottoNo) {
        this.lottoNo = lottoNo;
    }

    static LottoNo valueOf(final int lottoNo) {
        return cached.stream()
                     .filter(l -> l.lottoNo == lottoNo)
                     .findAny()
                     .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_UNEXPECTED_RANGE_NUMBER))
            ;
    }

    static LottoNo empty() {
        return empty;
    }

    static List<LottoNo> shuffle(){
        final List<LottoNo> lottoNoList = new ArrayList<>(cached);
        Collections.shuffle(lottoNoList);

        return Collections.unmodifiableList(lottoNoList);
    }

    int getLottoNo() {
        return lottoNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNo lottoNo1 = (LottoNo) o;
        return lottoNo == lottoNo1.lottoNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNo);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNo);
    }
}
