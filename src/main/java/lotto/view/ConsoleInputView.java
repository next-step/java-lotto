package lotto.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    @Override
    public int purchaseGuide() {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        int lottoCount = payment / 1000;
        System.out.println(lottoCount + "개를 구입했습니다.");
        scanner.close();
        return lottoCount;
    }
}
