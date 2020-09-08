package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class InputView {
    private static final String DELIMITER = ",";

    Scanner scan = new Scanner(System.in);
    public int getPurchaseAmt() {
        System.out.println("구입금액을 입력하세요.");
        int purchaseAmt = scan.nextInt();
        return purchaseAmt;
    }

    public List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String inputStr = scan.nextLine();
        return Arrays.stream(inputStr.split(DELIMITER))
                     .map(Integer::new)
                     .collect(toCollection(ArrayList::new));
    }
}
