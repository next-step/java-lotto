package Lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final BigDecimal buyAmount;
    private String hitNumbers;
    private int bonusNumber;


    public InputView(BigDecimal buyAmount) {
        this.buyAmount = buyAmount;
    }

    public static InputView inputBuyingPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구매금액을 입력해 주세요.");
        BigDecimal buyAmount = sc.nextBigDecimal();

        return new InputView(buyAmount);
    }

    public void inputWinInfomation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("지난주 당첨번호를 입력하세요.");
        hitNumbers = sc.nextLine();

        System.out.println("보너스 볼을 입력해주세요.");
        bonusNumber = sc.nextInt();
    }

    public List<Integer> getHitNumbers() {
        return Arrays.stream(hitNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public BigDecimal getBuyAmount() {
        return buyAmount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
