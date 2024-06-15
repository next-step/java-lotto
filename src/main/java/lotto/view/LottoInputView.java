package lotto.view;

import lotto.entity.Lotto;
import lotto.entity.WinningLotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LottoInputView {
    private final Scanner scan = new Scanner(System.in);

    private Object inputProcess(Supplier<?> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception ex) {
                System.out.printf("[ERROR] %s\n", ex.getMessage());
            }
        }
    }

    public int inputMoney() {
        return (int) inputProcess(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            return Integer.parseInt(scan.nextLine());
        });
    }

    public WinningLotto inputWinningLotto() {
        return (WinningLotto) inputProcess(() -> {
            var winningLotto = inputWinningLotto0();
            var bonusNumber = inputBonusNumber();
            return new WinningLotto(winningLotto, bonusNumber);
        });
    }

    private Lotto inputWinningLotto0() {
        System.out.println("지난 주 당첨번호를 입력해 주세요.");
        var winningNumbers = Arrays.stream(scan.nextLine().split(","))
                .map(s -> {
                    var result = s.trim();
                    return Integer.parseInt(result);
                })
                .collect(Collectors.toSet());

        return new Lotto(winningNumbers);
    }

    private int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scan.nextLine());
    }
}
