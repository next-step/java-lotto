package lotto.view;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public int promptPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }

    public ArrayList<Integer> promptWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = new Scanner(System.in).nextLine();

        return Arrays.stream(input.replaceAll(" ", "").split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
