package com.seok2.lotto.domain.lotto;

import com.seok2.common.utils.StringUtils;
import com.seok2.lotto.domain.common.Money;
import com.seok2.lotto.domain.rank.Rank;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Objects;

public class Lotto {

    private static final String PRINT_FORMAT = "{0}: {1}";
    public static final Money PRICE = Money.of(1_000);
    public static final int LENGTH = 6;
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 45;

    private final Auto auto;
    private final LottoNumbers lottoNumbers;

    private Lotto(Auto auto, LottoNumbers lottoNumbers) {
        this.auto = auto;
        this.lottoNumbers = lottoNumbers;
    }

    private static Lotto of(Auto auto, LottoNumbers lottoNumbers) {
        return new Lotto(auto, lottoNumbers);
    }

    private static Lotto of(Auto auto, int... lottoNumbers) {
        return of(auto, LottoNumbers.of(lottoNumbers));
    }

    public static Lotto auto(int... lottoNumbers) {
        return of(Auto.TRUE, lottoNumbers);
    }

    public static Lotto auto(String lottoNumbers) {
        return auto(parseIntArray(lottoNumbers));
    }

    public static Lotto manual(int... lottoNumbers) {
        return of(Auto.FALSE, lottoNumbers);
    }

    public static Lotto manual(String lottoNumbers) {
        return manual(parseIntArray(lottoNumbers));
    }

    private static int[] parseIntArray(String lottoNumbers) {
        return Arrays.stream(StringUtils.split(lottoNumbers))
            .map(Integer::parseInt)
            .mapToInt(i -> i)
            .toArray();
    }


    boolean contains(LottoNumber bonus) {
        return this.lottoNumbers.contains(bonus);
    }

    boolean contains(int bonus) {
        return contains(LottoNumber.of(bonus));
    }


    Rank check(Lotto winning, LottoNumber bonus) {
        return Rank.find(lottoNumbers.match(winning.lottoNumbers), contains(bonus));
    }

    boolean isAuto() {
        return auto.isAuto();
    }

    @Override
    public String toString() {
        return MessageFormat.format(PRINT_FORMAT, auto.getDescription(), lottoNumbers.toString());
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
