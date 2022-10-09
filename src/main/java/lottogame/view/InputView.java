package lottogame.view;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

import lottogame.domain.Money;
import lottogame.view.exception.InvalidInputException;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public Money getMoneyInput() {
        return wrapMethodCall(this::doGetMoneyInput);
    }

    public int getManualLottoCount() {
        return wrapMethodCall(this::doGetManualLottoCount);
    }

    public List<List<Integer>> getManualLottoNumbers(int lottoCount) {
        if (lottoCount <= 0) {
            return List.of();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < lottoCount; ++i) {
            manualLottoNumbers.add(wrapMethodCall(this::doGetLottoNumbers));
        }
        System.out.println();

        return manualLottoNumbers;
    }

    public List<Integer> getLastWeekLottoResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> result = wrapMethodCall(this::doGetLottoNumbers);
        System.out.println();
        return result;
    }

    public int getBonusNumberInput() {
        return wrapMethodCall(this::doGetBonusNumberInput);
    }

    private Money doGetMoneyInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        Money money = new Money(scanner.nextInt());
        System.out.println();

        return money;
    }

    private int doGetManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualTicketCount = scanner.nextInt();
        System.out.println();
        clearBuffer();

        return manualTicketCount;
    }

    private List<Integer> doGetLottoNumbers() {
        return Arrays.stream(scanner.nextLine().split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());
    }

    private int doGetBonusNumberInput() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private <T> T wrapMethodCall(Supplier<T> method) {
        try {
            return method.get();
        } catch (Exception e) {
            throw new InvalidInputException("잘못된 형식의 입력을 입력하셨습니다.");
        }
    }

    private void clearBuffer() {
        scanner.nextLine();
    }
}
