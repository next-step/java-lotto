package lotto.ui;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoHitInfo {

    private final String hitNumbers;
    private final LottoNumber bonusNumber;

    public LottoHitInfo(String hitNumbers, LottoNumber bonusNumber) {
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

        return new LottoHitInfo(hitNumbers, new LottoNumber(bonusNumber));
    }

    public List<LottoNumber> getHitNumbers() {
        return Arrays.stream(hitNumbers.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
