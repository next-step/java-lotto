package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.model.Profit.LOTTO_PRICE;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int quantity() {
        System.out.println("구매금액을 입력해 주세요");
        return SCANNER.nextInt() / LOTTO_PRICE;
    }

    public static Lotto winningLotto() {
        System.out.println("지난주 당첨 번호를 입력해주세요");
        SCANNER.nextLine();
        String[] split = SCANNER.nextLine().split(",");

        return new Lotto(parseLotto(split));
    }

    public static LottoNumber bonusLotto() {
        System.out.println("보너스 볼을 입력해주세요");
        return LottoNumber.cacheLottoNumber(SCANNER.nextInt());
    }

    private static Set<LottoNumber> parseLotto(final String[] split) {
        return Arrays.stream(split)
                .map(parsing())
                .collect(Collectors.toSet());
    }

    private static Function<String, LottoNumber> parsing() {
        return string -> LottoNumber.cacheLottoNumber(Integer.parseInt(string));
    }
}
