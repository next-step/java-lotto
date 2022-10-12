package lotto.views;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domains.Lotto;
import lotto.domains.LottoGenerator;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public List<Lotto> inputPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());

        List<Lotto> lottos = lottoGenerator.purchaseByAuto(money);
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.forEach(System.out::println);
        System.out.println();

        return lottos;
    }

    public Lotto inputLastWinner() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println();
        return lottoGenerator.purchaseByManual(numbers);
    }
}
