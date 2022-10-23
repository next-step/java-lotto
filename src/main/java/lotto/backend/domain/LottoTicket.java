package lotto.backend.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoTicket {

    private static final int PRICE_PER_LOTTO = 1000;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> value;

    private LottoTicket(List<LottoNumber> value) {
        validate(value);
        this.value = value;
    }

    public static LottoTicket of(int[] value) {
        return Arrays.stream(value)
                .mapToObj(LottoNumber::of)
                .collect(collectingAndThen(toList(), LottoTicket::new));
    }

    public static LottoTickets of(int money) {
        return Stream.generate(LottoTicket::create)
                .limit(money / PRICE_PER_LOTTO)
                .collect(collectingAndThen(toList(), LottoTickets::new));
    }

    private static LottoTicket create() {
        return LottoNumber.createNumbers(LOTTO_NUMBER_SIZE).stream()
                .sorted()
                .collect(collectingAndThen(toList(), LottoTicket::new));
    }

    public int countMatch(LottoTicket other) {
        return (int) value.stream()
                .filter(other.value::contains)
                .count();
    }

    public int price() {
        return PRICE_PER_LOTTO;
    }

    private void validate(List<LottoNumber> value) {
        checkSize(value);
        checkDuplicatedNumber(value);
    }

    private void checkSize(List<LottoNumber> value) {
        if (LOTTO_NUMBER_SIZE != value.size()) {
            throw new IllegalArgumentException("로또 번호의 숫자는 6개 입니다.");
        }
    }

    private void checkDuplicatedNumber(List<LottoNumber> value) {
        boolean duplicated = value.stream().distinct().count() != value.size();
        if (duplicated) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public String print() {
        return this.value.stream()
                .map(LottoNumber::print)
                .collect(Collectors.joining(" ,", "[", "]"));
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
