package lotto.step2.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LottoBoard {

    private final List<Long> boards;

    private LottoBoard(final List<Long> boards) {
        this.boards = boards;
    }

    public static LottoBoard of(final List<Long> boards) {
        return new LottoBoard(boards);
    }

    public Stream<Long> stream() {
        return boards.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoBoard that = (LottoBoard) o;
        return Objects.equals(boards, that.boards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boards);
    }
}
