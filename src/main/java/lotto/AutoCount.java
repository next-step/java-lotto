package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutoCount {

    private final long count;

    public AutoCount(long count) {
        if (count < 0) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_COUNT.print());
        }
        this.count = count;
    }

    public List<Lotto> buyLottos() {
        return Stream.generate(Lotto::new)
                .limit(this.count)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutoCount)) return false;
        AutoCount autoCount = (AutoCount) o;
        return count == autoCount.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return String.valueOf(this.count);
    }
}
