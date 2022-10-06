package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoInputView {

    private final Scanner scanner = new Scanner(System.in);

    public int readPayAmount() {
        System.out.println("구입 금액을 입력해 주세요");
        int pay = scanner.nextInt();
        scanner.nextLine();
        return pay;
    }

    public Lotto readBeforeLotto() {
        System.out.println("이전 로또 번호를 입력 해주세요");
        String text = scanner.nextLine();
        String[] lottoNumbers = text.replace(" ", "").split(",");

        return Lotto.of(toList(lottoNumbers));
    }

    private static List<Integer> toList(String[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .map(token -> Integer.parseInt(token))
                .collect(Collectors.toList());
    }
}
