package io.mwkwon.lotto.domain;

import java.util.*;

public final class Lotto {
    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();
    public static final int FROM_INDEX = 0;
    public static final int LOTTO_BOUND = 6;

    private final Set<LottoNumber> lottoNumbers;

    static {
        for (int i = LottoNumber.MIN_LOTTO_NUMBER; i <= LottoNumber.MAX_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS.add(new LottoNumber(i));
        }
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public static Lotto createAutoLotto() {
        List<LottoNumber> autoLottoNumbers = createAutoLottoNumbers();
        return new Lotto(autoLottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    private static List<LottoNumber> createAutoLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.subList(FROM_INDEX, LOTTO_BOUND);
    }
}
