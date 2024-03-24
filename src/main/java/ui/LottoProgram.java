package ui;

import lotto.*;

import java.util.Scanner;

public class LottoProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();

        LottoMachine machine = new LottoMachine();
        Lottos lottos = machine.buyLotto(new Money(price));

        System.out.println(String.format("%d를 구매했습니다", lottos.count()));
        LottoView lottoView = new LottoView();
        lottoView.printLottoNumbers(lottos);


        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = scanner.next();

        LottoNumbers winningLottoNumbers = LottoNumbers.toNumbers(line);

        LottoSummary summary = machine.summarizeLotto(winningLottoNumbers, lottos);
        lottoView.printLottoSummary(summary);
    }
}
