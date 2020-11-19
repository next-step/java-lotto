package lotto.domain.winning;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created By mand2 on 2020-11-19.
 */
public class WinningNumber {

    private final TreeSet<Integer> winningNumber;

    private WinningNumber(TreeSet<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber of(String inputWinningNumber) {
        String[] inputs = inputWinningNumber.split(", ");
        TreeSet<Integer> winningNumber = Stream.of(inputs)
                .map(Integer::valueOf).collect(toCollection(TreeSet::new));

        return new WinningNumber(new TreeSet<>(winningNumber));
    }

    public List<Integer> value() {
        return Collections.unmodifiableList(new ArrayList<>(this.winningNumber));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return Objects.equals(winningNumber, that.winningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber);
    }
}
