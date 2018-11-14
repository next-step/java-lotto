package net.chandol.lotto.domain;

import java.util.List;

import static com.google.common.primitives.Ints.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static net.chandol.lotto.util.LottoNumberValidator.validateUniqueNumbers;
import static net.chandol.lotto.util.RandomLottoNumberProvider.getNumbers;

public class LottoNumber {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private List<LottoNumberItem> items;

    private LottoNumber(List<Integer> numbers) {
        validateNonNull(numbers);

        List<LottoNumberItem> items = numbers.stream()
                .map(LottoNumberItem::new)
                .collect(toList());

        validateNumbers(items);
        this.items = items;
    }

    private void validateNonNull(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("null은 허용되지 않습니다.");
        }
    }

    public List<LottoNumberItem> getLottoNumbers() {
        return unmodifiableList(items);
    }

    private void validateNumbers(List<LottoNumberItem> items) {
        validateNumberSize(items);
        validateUniqueNumbers(items);
    }

    private void validateNumberSize(List<LottoNumberItem> items) {
        if (items == null || items.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자를 확인해주세요.");
        }
    }

    public List<LottoNumberItem> getMatchNumbers(LottoNumber another) {
        return another.getLottoNumbers().stream()
                .filter(i -> items.contains(i))
                .collect(toList());
    }

    public Integer getMatchSize(LottoNumber another) {
        return getMatchNumbers(another).size();
    }

    public boolean containsNumber(LottoNumberItem bonusNumber) {
        return this.getLottoNumbers().contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;
        if (items == null || that.items == null) {
            return false;
        } else {
            return items.containsAll(that.items) && items.containsAll(that.items);
        }
    }

    public static LottoNumber direct(List<Integer> numbers) {
        return new LottoNumber(numbers);
    }

    public static LottoNumber direct(int n1, int n2, int n3, int n4, int n5, int n6) {
        return new LottoNumber(asList(n1, n2, n3, n4, n5, n6));
    }

    public static LottoNumber auto() {
        return new LottoNumber(getNumbers());
    }
}
