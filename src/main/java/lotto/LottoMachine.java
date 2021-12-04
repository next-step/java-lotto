package lotto;

import java.util.Scanner;

public class LottoMachine {
    private final Scanner scanner = new Scanner(System.in);
    private Lottos lottos;

    public LottoMachine() {
    }

    public LottoMachine(int quantity) {
        this.lottos = new Lottos(quantity);
    }

    public void run() {
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        int quantity = amount / 1000;
        System.out.println(quantity + "개를 구매했습니다.");

        this.lottos = new Lottos(quantity);

        for (Lotto lotto : lottos.getValues()) {
            System.out.println(lotto.lottoNumbers().getValues());
        }

        System.out.println("당첨 번호를 입력해주세요");
        String input = scanner.next();
        LottoNumbers winningNumbers = new LottoNumbers(input);

        System.out.println("winningNumbers = " + winningNumbers);

        long result = lottos.result(winningNumbers, count -> count == 3);
        System.out.println("3개 일치 " + result);

        long result2 = lottos.result(winningNumbers, count -> count == 4);
        System.out.println("4개 일치 " + result2);

        long result3 = lottos.result(winningNumbers, count -> count == 5);
        System.out.println("5개 일치 " + result3);
    }

    public Lottos lottos() {
        return this.lottos;
    }
}
