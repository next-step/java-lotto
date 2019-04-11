package view;

import domain.Lotto;
import domain.LottoMoney;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static LottoMoney getLottoCountFromInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new LottoMoney(scanner.nextInt());
    }

    public static int getNumberOfManualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Lotto> getUserLottos(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> userLottos = new ArrayList<>();

        while (manualLottoCount > 0) {
            scanner = new Scanner(System.in);

            List<Integer> numbers = splitStringToLotto(scanner.nextLine());
            Lotto lotto = new Lotto(numbers);

            userLottos.add(lotto);
            manualLottoCount--;
        }
        return userLottos;
    }

    public static void printNumberOfLottos(LottoMoney money, int manualLottoCount) {
        System.out.println("수동으로 "+ manualLottoCount + "개, 자동으로 "
                + (money.getNumberOfLotto() - manualLottoCount) + "개를 구매했습니다");
    }


    public static WinningLotto getWinnerNoByInput() {
       System.out.println("지난 주 당첨 번호를 입력해 주세요.(,로 숫자 구분)");
       scanner = new Scanner(System.in);
       List<Integer> specifiedNumbers = splitStringToLotto(scanner.nextLine());

        System.out.println("보너스 볼을 입력해 주세요.");
        return new WinningLotto(specifiedNumbers, scanner.nextInt());
    }

    public static List<Integer> splitStringToLotto(String input) {
        return Arrays.stream(input.split(","))
                     .mapToInt(Integer::valueOf)
                     .boxed()
                     .collect(toList());
    }

}
