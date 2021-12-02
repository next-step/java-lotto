package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.BOUND_END;
import static lotto.domain.LottoNumber.BOUND_START;

public class Lotto {

    public static final List<LottoNumber> BOUND_LOTTO_NUMBERS = IntStream.rangeClosed(BOUND_START, BOUND_END)
            .mapToObj(i -> LottoNumber.ofInt(i))
            .collect(Collectors.toList());

    public static final int PRICE = 1000;
    public static final int SIZE = 6;

    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        LottoValidator.checkSize(lotto);
        LottoValidator.checkDistinct(lotto);
        this.lotto = lotto;
    }

    private Lotto(String lottoString) {
        this(Arrays.stream(lottoString.split(","))
                .map(lottoNumberString -> LottoNumber.ofString(lottoNumberString))
                .collect(Collectors.toList()));
    }

    public static Lotto ofRandomLottoNumbers() {
        Collections.shuffle(BOUND_LOTTO_NUMBERS);
        return new Lotto(new ArrayList<LottoNumber>(BOUND_LOTTO_NUMBERS.subList(0, SIZE)));
    }

    public static Lotto ofManualStringLottoNumbers(String lottoString) {
        return new Lotto(lottoString);
    }


    public int countMatching(WinningLotto winningLotto) {
        Long count = lotto.stream()
                .filter(winningLotto::checkContainNumber)
                .count();
        return count.intValue();
    }

    public boolean checkContainNumber(LottoNumber bonusBall) {
        return lotto.contains(bonusBall);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
