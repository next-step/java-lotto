package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        return new Money(money);
    }

    public Lotto inputWinningLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String strLottoNumbers = scanner.nextLine();
        List<Integer> lottoNumbers = Arrays.stream(strLottoNumbers.split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}
