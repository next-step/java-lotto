package lotto.contoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int purchaseAmountQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
        int value = scanner.nextInt();
        scanner.nextLine();
        System.out.println(value / 1000 + "개를 구매했습니다.");

        return value;
    }

    public List<Integer> findPrevLottoNumbers() {
        List<Integer> prevLottoNumber = new ArrayList<>();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String value = scanner.nextLine();
        for (String number : value.split(", ")) {
            prevLottoNumber.add(Integer.valueOf(number.trim()));
        }

        return prevLottoNumber;
    }
}
