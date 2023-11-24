package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    public static int priceView() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("로또 1장의 가격은 1000원입니다.");
        }
        int number = money / 1000;
        System.out.println(number + "개를 구매했습니다.");
        return number;
    }

    public static Lotto winningLottoView() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        List<LottoNumber> lotto = getLottoNumbers();
        return new Lotto(lotto);
    }

    private static List<LottoNumber> getLottoNumbers() {
        List<LottoNumber> lotto = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return lotto;
    }
}
