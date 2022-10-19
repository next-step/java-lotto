package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final Money LOTTO_PRICE = new Money(1000);
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lotto = new ArrayList<>();

    public Lotto(Set<Integer> lottoNumbers) {
        validate(lottoNumbers);
        for (int lottoNumber : lottoNumbers) {
            lotto.add(new LottoNumber(lottoNumber));
        }
    }

    public Lotto(String winningNumbers) {
        this(splitLotto(winningNumbers));
    }

    private static Set<Integer> splitLotto(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    private void validate(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또의 개수가 맞지 않습니다.");
        }
    }

    public int countMatchNumber(Lotto lotto) {
        return (int) lotto.getLotto().stream().filter(this.lotto::contains).count();
    }

    public boolean isMatch(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    @Override
    public String toString() {
        return String.valueOf(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return lotto.equals(lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
