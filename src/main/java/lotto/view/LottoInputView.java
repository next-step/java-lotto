package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoInputView {

    private final Scanner scanner = new Scanner(System.in);

    private static List<Integer> toList(String[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int readPayAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        int pay = scanner.nextInt();
        scanner.nextLine();
        return pay;
    }

    public Lotto readBeforeWinLotto() {
        System.out.println("이전 로또 번호를 입력 해주세요");
        String text = scanner.nextLine();
        String[] lottoNumbers = text.replace(" ", "").split(",");

        return Lotto.of(toList(lottoNumbers));
    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();

        Optional.of(bonusNumber)
                .filter(n -> n > LottoNumbers.MAX_LOTTO_NUMBER)
                .ifPresent(n -> new IllegalArgumentException(String.format("%d보다 큰값은 입력할수 없습니다. 입력값:%d", LottoNumbers.MAX_LOTTO_NUMBER, n)));

        return bonusNumber;
    }
}
