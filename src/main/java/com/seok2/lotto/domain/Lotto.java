package com.seok2.lotto.domain;

import java.text.MessageFormat;
import java.util.Objects;

public class Lotto {

    private static final String LOTTO_PRINT_FORMAT = "{0}: {1}";
    static final Money LOTTO_PRICE = Money.of(1_000);
    static final int LOTTO_MIN_NUMBER = 1;
    static final int LOTTO_MAX_NUMBER = 45;
    static final int LOTTO_LENGTH = 6;

    private final LottoNumbers lottoNumbers;
    private final Auto auto;

    private Lotto(LottoNumbers lottoNumbers, Auto auto) {
        this.lottoNumbers = lottoNumbers;
        this.auto = auto;
    }
    public static Lotto of(Auto auto, int ... lottoNumbers) {
        return new Lotto(LottoNumbers.of(lottoNumbers), auto);
    }

    public static Lotto of(Auto auto, LottoNumbers lottoNumbers) {
        return new Lotto(lottoNumbers, auto);
    }

    public static Lotto of(int ... lottoNumbers) {
        return of(Auto.TRUE, lottoNumbers);
    }

    boolean contains(LottoNumber bonus) {
        return this.lottoNumbers.contains(bonus);
    }

    Rank check(Lotto winning, LottoNumber bonus) {
        return Rank.find(lottoNumbers.match(winning.lottoNumbers), contains(bonus));
    }

    boolean isAuto() {
        return auto.isAuto();
    }

    @Override
    public String toString() {
        return MessageFormat.format(LOTTO_PRINT_FORMAT, auto.getDescription(), lottoNumbers.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto that = (Lotto) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) &&
            Objects.equals(auto, that.auto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, auto);
    }


}
