package study.lotto.view.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ManualLottoParser {

    private final List<Set<Integer>> manualNumbers;

    private ManualLottoParser(final List<Set<Integer>> manualNumbers) {
        this.manualNumbers = manualNumbers;
    }

    public static ManualLottoParser of(final List<Set<Integer>> manualNumbers) {
        return new ManualLottoParser(manualNumbers);
    }

    public List<Set<Integer>> getManualNumbers() {
        return Collections.unmodifiableList(manualNumbers);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof ManualLottoParser)) return false;
        final ManualLottoParser that = (ManualLottoParser) o;
        return Objects.equals(manualNumbers, that.manualNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manualNumbers);
    }
}
