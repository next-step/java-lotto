package view;

import domain.Lotto;
import domain.LottoGame;
import domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static List<Lotto> getManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] split = scanner.nextLine().split(", ");
            TreeSet<LottoNumber> manualLottoNumbers = Arrays.stream(split)
                    .map(Integer::parseInt)
                    .map(LottoNumber::new)
                    .collect(Collectors.toCollection(TreeSet::new));

            Lotto manualLotto = new Lotto(manualLottoNumbers);
            manualLottos.add(manualLotto);
        }
        return manualLottos;
    }

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getWinningNumberString() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return scanner.nextLine();
    }

    public static String getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}