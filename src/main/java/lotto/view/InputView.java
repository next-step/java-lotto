package lotto.view;

import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public Money promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(new Scanner(System.in).nextInt());
    }

    public ArrayList<Integer> promptWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = new Scanner(System.in).nextLine();

        return Arrays.stream(input.replaceAll(" ", "").split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Integer promptBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.valueOf(new Scanner(System.in).nextLine());
    }

}
