package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Lotto;
import lotto.domain.LottoNum;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPaidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
    }

    public static int getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();
        scanner.nextLine();
        return manualCount;
    }

    public static List<Lotto> getManualLottoNumbers(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottoNumbers = new ArrayList<>();
        while (manualLottoNumbers.size() < manualCount) {
            String manualLottoNumber = scanner.nextLine();
            manualLottoNumbers.add(new Lotto(convertStringToList(manualLottoNumber)));
        }
        return manualLottoNumbers;
    }

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<LottoNum> lastWeekLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return convertStringToList(scanner.nextLine());
    }

    public static List<LottoNum> convertStringToList(String lastWeekLottoResult) {
        String[] split = lastWeekLottoResult.trim().split(",");
        List<LottoNum> integerList = new ArrayList<>();
        for (String s : split) {
            integerList.add(new LottoNum(Integer.parseInt(s.trim())));
        }
        return integerList;
    }

}
