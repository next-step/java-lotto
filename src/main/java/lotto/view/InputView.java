package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private int purchaseAmount;
    private List<Integer> lastWeeksCollectNumbers;

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Integer> getLastWeeksCollectNumbers() {
        return lastWeeksCollectNumbers;
    }

    public void setPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = scanner.nextInt();
        this.purchaseAmount = purchaseAmount;
    }

    public void setLastWeeksCollectNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String lastWeeksCollectNumbers = scanner.nextLine();
        String[] split = lastWeeksCollectNumbers.split(", ");
        this.lastWeeksCollectNumbers = Arrays
                .stream(split)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}