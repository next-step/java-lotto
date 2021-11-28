package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private final Scanner scanner;
    private final int count;
    private final List<Lotto> lottos;

    public InputView() {
        scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해 주세요.");
        int money = scanner.nextInt();
        count = money / 1000;
        lottos = IntStream.range(0, count).mapToObj(i -> new Lotto()).collect(Collectors.toList());
        System.out.println(count + "개를 구매했습니다.");
        printLottos();
    }

    private void printLottos() {
        this.lottos.forEach(lotto -> System.out.println(lotto.getNumbers().getNumbers()));
    }

    public Lottos getLottos() {
        return new Lottos(lottos);
    }

}