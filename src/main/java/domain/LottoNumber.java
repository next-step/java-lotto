package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber extends Number implements Comparable<LottoNumber>{
    private static final Number min = new Number(1);
    private static final Number max = new Number(45);

    private static final List<LottoNumber> allLottoNumbers = IntStream.range(min.value(), max.value() + 1)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    public static List<LottoNumber> allLottoNumbers() {
        return new ArrayList<>(allLottoNumbers);
    }

    public LottoNumber(String value) {
        super(value);
        if (!isValidLottoNumber(this.value())) {
            throw new IllegalArgumentException("Invalid lotto number: " + value);
        }
    }

    public LottoNumber(int value) {
        super(value);
        if (!isValidLottoNumber(this.value())) {
            throw new IllegalArgumentException("Invalid lotto number: " + value);
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value() - o.value();
    }

    private boolean isValidLottoNumber(int value) {
        return min.value() <= value && value <= max.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return value() == that.value();
    }

    @Override
    public int hashCode() {
        return value();
    }

    @Override
    public String toString() {
        return String.valueOf(value());
    }
}
