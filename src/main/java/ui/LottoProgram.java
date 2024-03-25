package ui;

import lotto.*;

import java.util.Scanner;

public class LottoProgram {
    private static final LottoView VIEWER = new LottoView();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        int price = SCANNER.nextInt();
        Money money = new Money(price);

        Lottos lottos = buyLottos(money);
        LottoNumbers winNums = createWinLottoNumbers();
        LottoSummary summary = new LottoResult(lottos.getRanks(winNums), money).toLottoSummary();
        VIEWER.printLottoSummary(summary);
    }

    private static LottoNumbers createWinLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = SCANNER.next();

        return new LottoNumbers(line);
    }

    private static Lottos buyLottos(Money money) {

        Lottos lottos = LottoSeller.sell(money, new RandomLottoNumberStrategy());
        System.out.println(String.format("%d를 구매했습니다", lottos.count()));
        VIEWER.printLottoNumbers(lottos);

        return lottos;
    }

}
