package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoHitInfo {

    private final String hitNumbers;
    private final int bonusNumber;

    public LottoHitInfo(String hitNumbers, int bonusNumber) {
        this.hitNumbers = hitNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoHitInfo inputHitInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("지난주 당첨번호를 입력하세요.");
        String hitNumbers = sc.nextLine();

        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = sc.nextInt();
        sc.nextLine();

        return new LottoHitInfo(hitNumbers, bonusNumber);
    }

    public List<Integer> getHitNumbers() {
        return Arrays.stream(hitNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
