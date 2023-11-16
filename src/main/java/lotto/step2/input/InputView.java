package lotto.step2.input;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoGenerator;
import lotto.step2.domain.LottoNumber;
import lotto.step2.domain.WinnerNumbers;
import lotto.step2.service.LottoProgram;

import java.util.*;

public class InputView {
    private InputView() {
        throw new IllegalStateException("Utility class");
    }

    public static UserInput input() {
        final PurchaseAmount purchaseAmount = inputPurchaseAmount();
        final PassiveLottoCount passiveLottoCount = inputPassiveLottoCount(purchaseAmount.getMaxPassiveLottoCount());
        final List<Lotto> passiveLottos = inputPassiveLottoNumbers(passiveLottoCount);

        return new UserInput(purchaseAmount, passiveLottoCount, passiveLottos);
    }

    private static List<Lotto> inputPassiveLottoNumbers(final PassiveLottoCount passiveLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> passiveLottos = new ArrayList<>();

        while (!passiveLottoCount.isSameWithListSize(passiveLottos)) {
            passiveLottos.add(inputLottoNumbers());
            System.out.printf("입력이 필요한 %d개 수동 로또 중에 %d개를 입력하셨습니다.%n",
                    passiveLottoCount.getValue(), passiveLottos.size());
        }

        return passiveLottos;
    }

    private static Lotto inputLottoNumbers() {
        Lotto lotto = null;

        while (lotto == null) {
            lotto = inputLottoNumbersByScanner();
        }

        return lotto;
    }

    private static Lotto inputLottoNumbersByScanner() {
        try {
            final String inputStringLine = new Scanner(System.in).nextLine();

            return LottoGenerator.generatePassiveLottos(inputStringLine);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            printPassiveLottoNumbersException();

            return null;
        }
    }

    private static void printPassiveLottoNumbersException() {
        System.out.println("1 ~ 45까지의 범위의 숫자로만, 중복되지 않게, ', '를 구분자로 해서, 총 6개를 입력해주세요. (예시 : 1, 2, 3, 4, 5, 6 / 11, 23, 29, 33, 40, 44)");
    }

    private static PurchaseAmount inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        PurchaseAmount purchaseAmount = null;

        while (purchaseAmount == null) {
            purchaseAmount = inputPurchaseAmountByScanner();
        }

        return purchaseAmount;
    }

    private static PurchaseAmount inputPurchaseAmountByScanner() {
        try {
            final int purchaseAmount = new Scanner(System.in).nextInt();

            return new PurchaseAmount(purchaseAmount);
        } catch (InputMismatchException | IllegalArgumentException e) {
            printPurchaseAmountException();

            return null;
        }
    }

    private static void printPurchaseAmountException() {
        System.out.printf(
                "구입 금액을 숫자로만 다시 입력해 주세요.%n(범위 : %d ~ %d)%n"
                , LottoProgram.LOTTO_PRICE, PurchaseAmount.MAX_VALUE);
    }

    private static PassiveLottoCount inputPassiveLottoCount(final int maxPassiveLottoCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        PassiveLottoCount passiveLottoCount = null;

        while (passiveLottoCount == null) {
            passiveLottoCount = inputPassiveLottoCountByScanner(maxPassiveLottoCount);
        }

        return passiveLottoCount;
    }

    private static PassiveLottoCount inputPassiveLottoCountByScanner(final int maxPassiveLottoCount) {
        try {
            final int passiveLottoCount = new Scanner(System.in).nextInt();

            return new PassiveLottoCount(passiveLottoCount, maxPassiveLottoCount);
        } catch (InputMismatchException | IllegalArgumentException e) {
            printPassiveLottoCountException(maxPassiveLottoCount);

            return null;
        }
    }

    private static void printPassiveLottoCountException(final int maxPassiveLottoCount) {
        System.out.printf(
                "수동으로 구매할 로또 수를 숫자로만 다시 입력해 주세요.%n(범위 : 1 ~ %d)%n"
                , maxPassiveLottoCount);
    }

    public static WinnerNumbers inputWinnersNumbers() {
        WinnerNumbers winnerNumbers = null;

        while (winnerNumbers == null) {
            winnerNumbers = inputWinnerNumberElement();
        }

        return winnerNumbers;
    }

    private static WinnerNumbers inputWinnerNumberElement() {
        try {
            final Lotto winnerLotto = inputWinnerLotto();
            final LottoNumber bonusLottoNumber = getBonusWinnerNumber();

            return new WinnerNumbers(winnerLotto, bonusLottoNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("보너스 번호는 중복될 수 없습니다. \n");

            return null;
        }
    }

    private static Lotto inputWinnerLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumbers();
    }

    private static LottoNumber getBonusWinnerNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNumber lottoNumber = null;

        while (lottoNumber == null) {
            lottoNumber = inputLottoNumberByScanner();
        }

        return lottoNumber;
    }

    private static LottoNumber inputLottoNumberByScanner() {
        try {
            final int lottoNumber = new Scanner(System.in).nextInt();

            return new LottoNumber(lottoNumber);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("보너스 볼을 숫자로만 다시 입력해 주세요. (범위 : 1 ~ 45)");

            return null;
        }
    }
}
