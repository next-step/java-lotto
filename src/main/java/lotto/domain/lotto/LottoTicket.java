package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
    private static final int SIZE=6;
    private final List<LottoNumber> values;

    private LottoTicket(List<LottoNumber> values) {
        validation(values);
        this.values = values;
    }

    private void validation(List<LottoNumber> values) {
        if (values.size() != SIZE) throw new IllegalArgumentException();
    }

    public static LottoTicket create(List<LottoNumber> values) {
        return new LottoTicket(
                Collections.unmodifiableList(new ArrayList<>(values))
        );
    }

    protected int size() {
        return this.values.size();
    }

    public List<LottoNumber> getValues() {
        return new ArrayList<>(this.values);
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
