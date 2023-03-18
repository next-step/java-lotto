package Lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private Scanner sc;

    public BigDecimal inputBuyingPrice() {
        sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        return sc.nextBigDecimal();
    }

    public int inputManualLottoCount() {
        sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public List<Integer> inputManualLottoNumber() {
        sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String manuelLottoNumbers = sc.nextLine();
        return Arrays.stream(manuelLottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> inputHitNumber() {
        sc = new Scanner(System.in);
        System.out.println("지난주 당첨번호를 입력하세요.");
        String hitNumbers = sc.nextLine();

        return Arrays.stream(hitNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        sc = new Scanner(System.in);
        System.out.println("보너스 번호를 입력하세요.");
        return sc.nextInt();
    }
}
