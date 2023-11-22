package lotto.view;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<Lotto> buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        Cash cash = new Cash(scanner.nextInt());

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();

        LottoCenter lottoCenter = new LottoCenter();
        List<Lotto> manualNumbers = manualLottoInput(manualCount);
        List<Lotto> lottos = lottoCenter.manualBuyLotto(cash, manualNumbers);

        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + (lottos.size() - manualCount) + "개를 구매했습니다.");

        return lottos;
    }

    private static List<Lotto> manualLottoInput(int manualCount) {
        List<Lotto> manualNumbers = new ArrayList<>();
        Scanner numbers = new Scanner(System.in);

        if (manualCount != 0) {
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
        for (int i = 0; i < manualCount; i++) {
            List<LottoNo> lottoNos = getLottoNos(numbers);
            Lotto lotto = new Lotto(lottoNos);
            manualNumbers.add(lotto);
        }
        return manualNumbers;
    }

    public WinningLotto winningLottoInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningLotto = new Lotto(getLottoNos(scanner));

        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNo bonusNumber = new LottoNo(scanner.nextInt());

        return new WinningLotto(winningLotto, bonusNumber);
    }

    private static List<LottoNo> getLottoNos(Scanner scanner) {
        String input = scanner.nextLine();
        if (input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("6개 숫자를 입력해주세요.");
        }
        String[] split = input.replaceAll("\\s", "").split(",");

        return Arrays.stream(split)
                .map(Integer::parseInt)
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }
}
