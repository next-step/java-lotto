package view;

import domain.Lotto;
import domain.LottoCreate;
import domain.Money;
import java.util.Scanner;
import java.util.stream.IntStream;

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

    public static void typeManualLotto(LottoCreate lottos, Money money) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        IntStream.range(0, money.turnOfManualLotto()).forEach(i -> lottos.getLottocreate().add(Lotto.fromCommas(sc.nextLine())));
    }
}