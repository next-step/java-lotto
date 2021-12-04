package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoMachine {
    private Lottos lottos;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        int quantity = amount / 1000;
        System.out.println(quantity + "개를 구매했습니다.");

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.draw(quantity);

        System.out.println("당첨 번호를 입력해주세요");
        String input = scanner.next();
        String[] split = input.split(",");
        List<Integer> winningNumbers = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("winningNumbers = " + winningNumbers);
    }

    private void draw(int quantity) {
        this.lottos = new Lottos(quantity);

        for (Lotto lotto : lottos.getValues()) {
            System.out.println(lotto.lottoNumbers().getValues());
        }
    }

    public LottoMachine() {
    }

    public LottoMachine(int quantity) {
        this.lottos = new Lottos(quantity);
    }

    public Lottos lottos() {
        return this.lottos;
    }
}
