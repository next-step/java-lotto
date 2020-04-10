package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 6개의 숫자만 가능합니다.");
        }
        this.lottoNumbers = Collections.unmodifiableSet(new HashSet<>(lottoNumbers));
    }

    public static Lotto of(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        return new Lotto(lottoNumbers);
    }

    public static Lotto of(Integer... numbers) {
        return of(Arrays.asList(numbers));
    }

    public static Lotto ofComma(String numbers) {
        String[] values = numbers.split(",");
        return new Lotto(
            Arrays.asList(values).stream()
                    .map(LottoNumber::of)
                    .collect(Collectors.toSet()));
    }

    public Rank match(WinningLotto winningLotto) {
        int match = winningLotto.getWinningLotto().lottoNumbers.stream()
                .filter(winningNumber -> lottoNumbers.contains(winningNumber))
                .collect(Collectors.reducing(0, e -> 1, Integer::sum));
        return Rank.valueOf(match, isMatchBonusNo(winningLotto.getBonusNumber()));
    }

    private boolean isMatchBonusNo(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
