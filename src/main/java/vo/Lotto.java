package vo;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }

        this.lotto = lotto;
    }

    public static Lotto of(Set<Integer> numbers) {
        Set<LottoNumber> lotto = new LinkedHashSet<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    public static Lotto of(Integer... numbers) {
        Set<LottoNumber> lotto = new LinkedHashSet<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    public static Lotto ofComma(String text) {
        if (Objects.isNull(text)) {
            throw new IllegalArgumentException();
        }
        return new Lotto(splitComma(text));
    }

    private static Set<LottoNumber> splitComma(String text) {
        String[] values = text.split(",");
        Set<LottoNumber> lotto = new LinkedHashSet<>();
        for (String value : values) {
            lotto.add(LottoNumber.of(value));
        }
        return lotto;
    }

    public int match(Lotto otherLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count += matchCount(otherLotto, lottoNumber);
        }
        return count;
    }

    private int matchCount(Lotto otherLotto, LottoNumber lottoNumber) {
        if (otherLotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
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

    @Override
    public String toString() {
        List<LottoNumber> lottoNumbers = new ArrayList(lotto);
        Collections.sort(lottoNumbers);
        return lottoNumbers.toString();
    }

    public int size() {
        return lotto.size();
    }
}
