package lotto.view;

import lotto.utils.Utils;
import lotto.dto.Lotto;
import lotto.service.LottoGame;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static int inputMoney(){

        System.out.println("구매금액을 입력해주세요.");
        int money = Integer.parseInt(sc.nextLine());
        System.out.println(LottoGame.getNumOfGames(money) + "개를 구매했습니다.");
        return money;
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





}
