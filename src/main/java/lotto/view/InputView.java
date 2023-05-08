package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int price(){
        System.out.println("구입금액을 입력해 주세요.");;
        return Integer.parseInt(scanner.nextLine());
    }

    public void buy(LottoGame lottoGame) {
        System.out.printf("%d개를 구매했습니다.\n", lottoGame.quantity());
    }

    public Set<LottoNumber> result() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        List<String> list = Arrays.asList(input.split(",\\s*"));
        return list.stream()
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toSet());
    }

    public LottoNumber bonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String input = scanner.nextLine();
        return new LottoNumber(Integer.parseInt(input));
    }
}
