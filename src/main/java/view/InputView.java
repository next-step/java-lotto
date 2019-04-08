package view;

import domain.Lotto;
import domain.LottoMoney;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static LottoMoney getLottoCountFromInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        LottoMoney money = new LottoMoney(scanner.nextInt());

        return money;
    }

    public static int getNumberOfManualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        int manualLottoCount = scanner.nextInt();
        return manualLottoCount;
    }

    public static List<Lotto> getUserLottos(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        List<Lotto> userLottos = new ArrayList<>();

        while (manualLottoCount > 0) {
            scanner = new Scanner(System.in);
            String[] inputs = splitStringToLotto(scanner.nextLine());
            List<Integer> numbers = new ArrayList<>();
            addAllToList(inputs, numbers);

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
        Scanner scanner = new Scanner(System.in);
        String[] inputs = splitStringToLotto(scanner.nextLine());

        List<Integer> specifedNumbers = new ArrayList<>();

        addAllToList(inputs, specifedNumbers);

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return new WinningLotto(specifedNumbers, bonusNumber);
    }

    private static List addAllToList(String[] inputs, List list) {
        for(String input : inputs) {
            list.add(toInt(input));
        }
        return list;
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }

    private static String[] splitStringToLotto(String input) {
        return input.split(",");
    }


}
