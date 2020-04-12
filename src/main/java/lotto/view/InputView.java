package lotto.view;

import lotto.model.LottoTicket;
import lotto.model.LottoTickets;
import lotto.model.wrapper.LottoNumber;
import lotto.model.wrapper.ManualLottoCount;
import lotto.model.wrapper.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;

import static lotto.utils.LottoUtil.convertTo;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static <R> R inputData(Supplier<R> inputSupplier) {
        R result = null;
        while (Objects.isNull(result)) {
            result = inputSupplier.get();
        }
        return result;
    }

    public static <T, R> R inputData(T semiInputComponent, Function<T, R> inputFunction) {
        R result = null;
        while (Objects.isNull(result)) {
            result = inputFunction.apply(semiInputComponent);
        }
        return result;
    }

    public static Payment inputPayment() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return Payment.of(inputInteger());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static ManualLottoCount inputManualLottoCount() {
        try {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            return ManualLottoCount.of(inputInteger());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static LottoTickets inputManualLotto(final ManualLottoCount manualLottoCount) {
        try {
            List<String> lottoNumberLines = inputManualLottoTickets(manualLottoCount.getCount());
            return LottoTickets.newInstance(convertTo(lottoNumberLines));
        } catch (NumberFormatException ex) {
            System.out.println("제대로 된 숫자를 입력하세요");
            return null;
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static LottoTicket inputWinningNumber() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            return LottoTicket.newInstance(convertTo(scanner.nextLine()));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static LottoNumber inputBonusNumber() {
        try {
            System.out.println("보너스 볼을 입력해 주세요.");
            return LottoNumber.of(inputInteger());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    private static List<String> inputManualLottoTickets(final int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoTickets = new ArrayList<>();
        for(int i = 0; i < manualLottoCount; i++) {
            manualLottoTickets.add(scanner.nextLine());
        }
        return manualLottoTickets;
    }

    private static int inputInteger() {
        final int manualLottoCount = scanner.nextInt();
        scanner.nextLine();
        return manualLottoCount;
    }
}
