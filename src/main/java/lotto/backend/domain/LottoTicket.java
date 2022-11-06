package lotto.backend.domain;

import lotto.backend.domain.generator.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int PRICE_PER_LOTTO = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final LottoType lottoType;
    private final Set<LottoNumber> value;

    public LottoTicket(Set<LottoNumber> numbers, LottoType lottoType) {
        checkSize(numbers);
        this.value = numbers;
        this.lottoType = lottoType;
    }

    public static LottoTicket create(List<Integer> numbers) {
        return new LottoTicket(convertToLottoNumbers(numbers), LottoType.AUTO);
    }

    public static LottoTicket create(NumberGenerator numberGenerator) {
        return new LottoTicket(numberGenerator.create(LOTTO_NUMBER_SIZE), numberGenerator.getLottoType());
    }

    private void checkSize(Set<LottoNumber> value) {
        if (LOTTO_NUMBER_SIZE != value.size()) {
            throw new IllegalArgumentException("로또 번호의 숫자는 6개 입니다.");
        }
    }

    private static Set<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toSet());
    }

    public int countOfMatch(LottoTicket winningLotto) {
        return (int) value.stream()
                .filter(winningLotto.value::contains)
                .count();
    }

    public boolean hasNumber(LottoNumber bonusNumber) {
        return value.contains(bonusNumber);
    }

    public boolean isAutoType() {
        return this.lottoType == LottoType.AUTO;
    }

    public Set<LottoNumber> getValue() {
        return Collections.unmodifiableSet(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
