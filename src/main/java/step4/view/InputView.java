package step4.view;

import step4.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return Integer.parseInt(value);
    }

    public int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return Integer.parseInt(value);
    }

    public List<Lotto> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<Lotto> manualLottos = new ArrayList<>();
        while (manualLottos.size() < manualLottoCount) {
            manualLottos.add(Lotto.ofComma(new Scanner(System.in).nextLine()));
        }

        return manualLottos;
    }

    public String inputResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public String inputBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }
}
