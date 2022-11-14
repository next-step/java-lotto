package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private Lotto winningLotto;

    public WinningLotto(Integer[] winningLotto) {
        this(new Lotto(Arrays.stream(winningLotto)
                .map(l -> LottoNumber.of(l))
                .collect(Collectors.toList())));
    }

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningLotto(String winningLotto) {
        this.winningLotto = parse(winningLotto);
    }

    public boolean same(List<LottoNumber> numbersList) {
        return this.winningLotto.equals(numbersList);
    }

    public int countSameNumber(List<LottoNumber> tryLotto) {
       return (int) tryLotto.stream()
               .filter(n -> winningLotto.contains(n))
               .count();
    }

    private static Lotto parse(String input) {
        return new Lotto(Arrays.stream(parseString(input))
                .map(s -> LottoNumber.of(s))
                .collect(Collectors.toList()));
    }

    private static String[] parseString(String input) {
        return input.split(", ");
    }

}
