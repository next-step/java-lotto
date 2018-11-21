package view;

import domain.Lotto;
import java.util.ArrayList;
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
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonumNo = sc.nextInt();
        return bonumNo;
    }

    public static int ManualLotto() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        return no;
    }

    public static List<Lotto> typeManualLotto(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        List<Lotto> list = new ArrayList<>();
        if(n != 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
            for (int i = 0; i < n; i++) {
                list.add(Lotto.fromCommas(sc.nextLine()));
            }
        }
        return list;
    }
}