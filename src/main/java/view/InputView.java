package view;

import domain.Lotto;
import domain.wrapper.BuyLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int setLottoPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static String lastLottoNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static String setBonusNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextLine();
    }

    public static int setBuyManualLottoCount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");

        return sc.nextInt();
    }

    public static List<Lotto> setManualLottoNumbers(int lottoCount){
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해주세요.");

        List<Lotto> lottos = new ArrayList<>();
        String[] lottoStringNumbers = new String[lottoCount];
        for(int i =0; i <lottoCount; i++){
            lottoStringNumbers[i] = sc.nextLine();
            lottos.add(new Lotto(lottoStringNumbers[i]));
        }
        return lottos;
    }

    public static List<Lotto> setManualLottoNumbers(BuyLotto buyManualLottoCount) {
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해주세요.");

        List<Lotto> lottos = new ArrayList<>();
        String[] lottoStringNumbers = new String[buyManualLottoCount.getLottoCount()];
        for(int i =0; i <buyManualLottoCount.getLottoCount(); i++){
            lottoStringNumbers[i] = sc.nextLine();
            lottos.add(new Lotto(lottoStringNumbers[i]));
        }
        return lottos;
    }
}
