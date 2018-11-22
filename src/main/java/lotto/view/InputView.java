package lotto.view;

import lotto.dto.Money;
import lotto.utils.Utils;
import lotto.dto.Lotto;
import lotto.service.LottoGame;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static int inputMoney(){

        System.out.println("구매금액을 입력해주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static Money inputMoney2(){

        System.out.println("구매금액을 입력해주세요.");
        return new Money(Integer.parseInt(sc.nextLine()));
    }

    public static void printLottoList(List<Lotto> lottos){
        System.out.println();
        for(Lotto lotto : lottos){
            System.out.println("[" + Utils.getCommaLottoNums(lotto.getLotto())+ "]");
        }
    }

    public static String winningNumbers(){

        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return sc.nextLine();
    }

    public static int bonusNum(){

        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    /**
     * step3 start
     */

    private static int manual(){
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static String manualgame(){
        int num = manual();
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요..");
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < num ; i++){
            sb.append(sc.nextLine()+"\n");
        }
        return sb.toString();
    }


}
