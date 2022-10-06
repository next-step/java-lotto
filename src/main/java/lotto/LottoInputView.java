package lotto;

import java.util.Scanner;

/**
 * Created by seungwoo.song on 2022-10-06
 */
public class LottoInputView {
    public int read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구임 금액을 입력해 주세요");
        return scanner.nextInt();
    }
}
