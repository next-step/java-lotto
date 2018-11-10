package raffle.view;

import raffle.lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int lottoAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int lottoAmount = sc.nextInt();
        return lottoAmount;
    }

    public static Lotto lastWeekLotto(){
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return new Lotto(Arrays.stream(sc.nextLine().split(", ")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList()));
    }

    public static int bonusLotto(){
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int bonusLotto = sc.nextInt();
        return bonusLotto;
    }

}
