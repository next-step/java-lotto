package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCenter;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<Lotto> buyTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");

        int cash = scanner.nextInt();
        List<Lotto> lottos = new LottoCenter().buyLotto(cash);

        System.out.println(lottos.size() + "개를 구매했습니다.");
        return lottos;
    }

    public WinningLotto winningLottoInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String input = scanner.nextLine().replaceAll("\\s", "");
        String[] split = input.split(",");

        List<Integer> inputNumbers = Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Lotto winningNumber = new Lotto(inputNumbers);

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return new WinningLotto(winningNumber, bonusNumber);
    }
}
