package lotto.domain.lotto;

import lotto.domain.lotto.exceptions.LottoTicketSizeException;

import java.util.*;

public class LottoTicket {
    private static final int EMPTY_SIZE = 0;
    private static final int SIZE = 6;
    private final List<LottoNumber> values;

    public static LottoTicket create(List<LottoNumber> values) {
        Collections.sort(values);
        return new LottoTicket(Collections.unmodifiableList(new ArrayList<>(values)));
    }

    public boolean isInThisTicket(LottoNumber lottoNumber) {
        return this.values.contains(lottoNumber);
    }

    public int howManyMatch(LottoTicket lottoTicket) {
        return (int) this.values.stream()
                .filter(lottoTicket::isInThisTicket)
                .count();
    }

    protected int size() {
        return this.values.size();
    }

    private LottoTicket(List<LottoNumber> values) {
        validation(values);
        this.values = values;
    }

    private void validation(List<LottoNumber> values) {
        if (values.size() != EMPTY_SIZE && values.size() != SIZE) {
            throw new LottoTicketSizeException("Lotto ticket can have only six lotto numbers");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (LottoNumber value: values) {
            builder.append(value.getValue()).append(", ");
        }
        String result = builder.toString().substring(0, builder.toString().length() - 2);
        return result + "]";
    }
}
