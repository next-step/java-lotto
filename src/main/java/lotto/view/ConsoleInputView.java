package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {

    @Override
    public int purchase() {
        System.out.println("구입 금액을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        int payment = scanner.nextInt();
        return payment / Lotto.PRICE;
    }

    @Override
    public List<Lotto> manualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        int amount = Integer.parseInt(scanner.nextLine());

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();

        for (int i=0;i<amount;i++){
            String manualLotto = scanner.nextLine();
            manualLottos.add(new Lotto(stringToList(manualLotto)));
        }
        return manualLottos;
    }

    public WinningLotto winningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        Scanner scanner = new Scanner(System.in);

        String winningLottoString = scanner.nextLine();
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusNumber = scanner.nextInt();
        System.out.println();
        return new WinningLotto(new Lotto(stringToList(winningLottoString)), bonusNumber);
    }

    private List<Integer> stringToList(String winningLottoString) {
        return Arrays
                .stream(winningLottoString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
