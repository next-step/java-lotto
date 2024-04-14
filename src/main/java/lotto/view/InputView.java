package lotto.view;

import static lotto.LottoType.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.Lotto;
import lotto.Lottos;
import lotto.NumberGenerator;

public class InputView {
    private static Scanner scanner;

    private static final String NUMBERS_SEPARATOR = ", ";

    public static int inputPurchaseAmount() {
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String[] inputWinningNumbers() {
        scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().split(NUMBERS_SEPARATOR);
    }

    public static String inputBonusNumber() {
        scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해주세요.");
        return scanner.nextLine();
    }

    public static int inputManualLottoCount(){
        scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Lottos inputManualLottoNumbers(int count){
        scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요");

        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<count; i++){
            lottos.add(NumberGenerator.generateManualNumbers(splitInputLine(NUMBERS_SEPARATOR)));
        }
        return Lottos.of(lottos);
    }

    private static String[] splitInputLine(String regex){
        scanner = new Scanner(System.in);
        return scanner.nextLine().split(regex);
    }

}
