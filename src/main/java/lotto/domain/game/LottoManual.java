package lotto.domain.game;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class LottoManual {

    private static final String REGEX = ",";
    private final List<Integer> lottoManual;

    public LottoManual(String lottoText) {
        this.lottoManual = toIntegers(lottoText);
    }

    private List<Integer> toIntegers(final String text) {
        String[] values = text.split(REGEX);
        return Arrays.stream(values)
            .map(value -> OptionalInt.of(Integer.parseInt(value.trim()))
                .orElseThrow(() -> new NumberFormatException("숫자를 입력해 주세요")))
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> getLottoManual() {
        return lottoManual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoManual that = (LottoManual) o;
        return Objects.equals(lottoManual, that.lottoManual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoManual);
    }
}
