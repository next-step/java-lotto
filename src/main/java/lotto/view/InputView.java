package lotto.view;

import lotto.domain.*;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Object retryableInput(Supplier<?> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            showErrorMessage(e);
            return retryableInput(supplier);
        } catch (Exception e) {
            showErrorMessage(e);
            return retryableInput(supplier);
        }
    }

    private static void showErrorMessage(Exception e) {
        SCANNER.reset();
        System.out.println(e.getMessage() + " 다시 입력해주세요.");
    }

    public static Budget retryableInputBuyBudget() {
        return (Budget) retryableInput(InputView::inputBuyBudget);
    }

    private static Budget inputBuyBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Budget(SCANNER.nextInt());
    }

    public static Count retryableInputSelfIssueCount(Budget budget) {
        return (Count) retryableInput(() -> InputView.inputSelfIssueCount(budget));
    }

    private static Count inputSelfIssueCount(Budget budget) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new Count(SCANNER.nextInt(), budget);
    }

    public static Lottos inputSelfIssueLottos(Count count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        SCANNER.nextLine();
        return new Lottos(inputSelfIssueLottosRecursion(count));
    }

    private static List<Lotto> inputSelfIssueLottosRecursion(Count count) {

        List<Lotto> selfIssueLotto = new ArrayList<>();
        if(count.isPositive()) {
            selfIssueLotto.addAll(inputSelfIssueLottosRecursion(count.decrease()));
            selfIssueLotto.add(retryableInputSelfIssueLottos());
            return selfIssueLotto;
        }
        return selfIssueLotto;
    }

    private static Lotto retryableInputSelfIssueLottos() {
        return (Lotto) retryableInput(InputView::inputSelfIssueLotto);
    }

    private static Lotto inputSelfIssueLotto() {
        return Lotto.ofNumbers(parseInts(split(SCANNER.nextLine())));
    }

    public static WinLotto retryableInputLastWinLotto() {
        return (WinLotto) retryableInput(InputView::inputLastWinLotto);
    }

    private static WinLotto inputLastWinLotto() {
        return new WinLotto(parseLottoNumbers(), parseBonusNumber());
    }

    private static Set<Integer> parseLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return parseInts(split(SCANNER.nextLine()));
    }

    private static Integer parseBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private static List<String> split(String input) {
        String[] result = input.split(", ");
        return Arrays.stream(result).collect(Collectors.toList());
    }

    private static Set<Integer> parseInts(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
