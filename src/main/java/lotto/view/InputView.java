package lotto.view;

import lotto.domain.model.lotto.PurchaseAmount;
import lotto.domain.model.lotto.BonusNumber;
import lotto.domain.model.lotto.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public PurchaseAmount inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchaseAmount(Integer.parseInt(scanner.nextLine()));
    }

    public BonusNumber inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusNumber(Integer.parseInt(scanner.nextLine()));
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
