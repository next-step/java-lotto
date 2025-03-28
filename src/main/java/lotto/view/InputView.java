package lotto.view;

import lotto.domain.model.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public Set<LottoNumber> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)");
        String[] tokens = scanner.nextLine().split(",");

        return Stream.of(tokens)
                .map(token -> Integer.parseInt(token.trim()))
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    public void close() {
        scanner.close();
    }
}
