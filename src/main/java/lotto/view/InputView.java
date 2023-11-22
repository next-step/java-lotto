package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<Lotto> buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        Cash cash = new Cash(scanner.nextInt());
        List<Lotto> lottos = new LottoCenter().buyLotto(cash);

        System.out.println(lottos.size() + "개를 구매했습니다.");
        return lottos;
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
