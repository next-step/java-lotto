package domain.lotto;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        double price = in.nextDouble();
        System.out.println((int) (price / 1000) + "개를 구매했습니다.");
        Lotto lotto = new Lotto(price);
        for (List<Integer> i : lotto.allLotto.lottoPapers) {
            System.out.println(i);
        }
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        in.nextLine();
        String winning_number = in.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus_number = in.nextInt();

    }
}
