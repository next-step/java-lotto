package raffle.view;

import java.util.Scanner;

public class InputView {

    public static int lottoAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int lottoAmount = sc.nextInt();
        return lottoAmount;
    }

    public static String[] lastWeekLotto(){
        System.out.println("\n 지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String[] lastWeekLotto = sc.nextLine().split(", ");
        return lastWeekLotto;
    }

}
