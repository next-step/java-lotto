package view;

import java.util.Scanner;

public class InputView {

    public static int setLottoPayment(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc =  new Scanner(System.in);
        return sc.nextInt();
    }

    public static String lastLottoNumber(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }



}
