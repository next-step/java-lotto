package view;

import domain.Lotto;
import domain.WinningLotto;

import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int purchasingAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int amount = sc.nextInt();
        return amount;
    }

    public static String typeLottoNumbers(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String str = sc.nextLine();
        return str;
    }

    public static int typeBonusNo() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonumNo = sc.nextInt();
        return bonumNo;
    }
}
