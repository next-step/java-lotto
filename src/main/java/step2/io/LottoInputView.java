package step2.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step2.domain.Lotto;
import step2.domain.LottoShop;
import step2.domain.Lottos;

public class LottoInputView {
    private static final Scanner in = new Scanner(System.in);

    public static Lottos buyLotto() {
        final long amount = Long.parseLong(in.nextLine());

        final LottoShop lottoShop = new LottoShop();
        return lottoShop.buy(amount);
    }

    public static Lotto winningLotto() {
        final String s = in.nextLine();
        final List<Integer> numbers = Arrays.asList(s.split(","))
                                            .stream()
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
