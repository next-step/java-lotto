package lotto;

import java.util.Scanner;

public class View {

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int lottoCount = lotto.buyLotto(scanner.nextInt());

        System.out.println(lottoCount + "개를 구매했습니다.");

    }
}
