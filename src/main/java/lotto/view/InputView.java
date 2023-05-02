package lotto.view;

import lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final int LOTTO_PRICE = 1000;
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int price(){
        System.out.println("구입금액을 입력해 주세요.");
        return buyLotto(scanner.nextInt());
    }

    private int buyLotto(int inputNumber) {
        int lottoCount = inputNumber / LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        return lottoCount;
    }

    public List<LottoNumber> result() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        List<String> list = Arrays.asList(input.split(",\\s*"));
        return list.stream()
                .map(s -> new LottoNumber(Integer.parseInt(s)))
                .collect(Collectors.toList());
    }
}
