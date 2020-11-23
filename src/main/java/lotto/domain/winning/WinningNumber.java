package lotto.domain.winning;

import lotto.domain.game.LottoNumber;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Created By mand2 on 2020-11-19.
 */
public class WinningNumber {

    private final LottoNumber winningNumber;

    private WinningNumber(LottoNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber of(String inputWinningNumber) {
        String[] inputs = inputWinningNumber.split(", ");
        LottoNumber lottoNumber = LottoNumber.of(Stream.of(inputs)
                .map(Integer::valueOf).collect(toList()));

        return new WinningNumber(lottoNumber);
    }

    public List<Integer> value() {
        return Collections.unmodifiableList(this.winningNumber.value());
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
