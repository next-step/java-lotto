package lottogame.view;

import lottogame.domain.LottoNumber;
import lottogame.domain.LottoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int userInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        return price;
    }

    public static String inputPrvLottoNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n지난 주 당첨 번호를 입력해주세요.");
        String input = scanner.nextLine();

        return input;
    }

    public static int inputBonusBall() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int bonusBall = scanner.nextInt();
        return bonusBall;
    }

    public static List<LottoNumber> inputManualLottoNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int number = scanner.nextInt();

        LottoUtil.checkNumberOfLotto(number);

        if (number == 0) {
            return new ArrayList<LottoNumber>();
        }

        Scanner inputLotto = new Scanner(System.in);
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumber> lottoNumber = new ArrayList<>();
        String input;
        List<Integer> lotto;
        for (int i = 0; i < number; i++) {
            input = inputLotto.nextLine();
            lotto = LottoUtil.coverStrToArrList(input);
            lottoNumber.add(new LottoNumber(lotto));
        }
        return lottoNumber;
    }
}
