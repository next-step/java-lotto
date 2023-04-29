package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;
    private LottoType lottoType;

    public Lotto(LottoType lottoType) {
        this.lottoNumbers = this.getNumbers();
        this.lottoType = lottoType;
    }

    private List<LottoNumber> getNumbers() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                                              .boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, LOTTO_SIZE).stream().map(LottoNumber::new).sorted().collect(Collectors.toList());
    }

    public Lotto(LottoType lottoType, int... numbers) {
        this(lottoType, Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }

    public Lotto(LottoType lottoType, List<Integer> numbers) {
        validate(numbers);
        this.lottoType = lottoType;
        this.lottoNumbers = numbers.stream().map(LottoNumber::new).sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 중복된 숫자 없이 6개가 필요합니다.");
        }
    }

    public List<LottoNumber> numbers() {
        return lottoNumbers;
    }

    public long matchNumber(List<LottoNumber> winNumbers) {
        return this.lottoNumbers.stream().filter(winNumbers::contains).count();
    }

    public long matchBonusNumber(LottoNumber bonusNumber) {
        return Collections.frequency(lottoNumbers, bonusNumber);
    }

    public boolean isAutomaticPurchasedLotto() {
        return this.lottoType.isAutomaticPurchasedLotto();
    }

    public boolean isManualPurchasedLotto() {
        return this.lottoType.isManualPurchasedLotto();
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

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + lottoNumbers +
                '}';
    }
}
