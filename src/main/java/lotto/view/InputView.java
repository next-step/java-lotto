package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.LottoNum;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getPaidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        scanner.nextLine();
        return money;
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
