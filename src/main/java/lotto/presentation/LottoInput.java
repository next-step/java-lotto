package lotto.presentation;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.utils.Splitter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * 입력 객체
 */
public final class LottoInput {
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_INT_ERROR_MESSAGE = "숫자만 입력해주세요.";
    private static final String INPUT_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_NEGATIVE_INT_ERROR_MESSAGE = "수동 구매 갯수는 0보다 커야합니다.";
    private final Scanner scanner;

    public LottoInput() {
        scanner = new Scanner(System.in);
    }

    /**
     * 로또 구매할 돈 입력
     *
     * @return
     */
    public Money inputMoneyToPurchaseLotto() {
        while (true) {
            try {
                System.out.println(INPUT_MONEY_MESSAGE);
                return new Money(scanner.nextInt());
            } catch (final InputMismatchException e) {
                System.out.println(INPUT_INT_ERROR_MESSAGE);
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
    }

    /**
     * 지난주 당첨번호 입력
     *
     * @return
     */
    public Lotto inputAnswerLottoNumbers() {
        while (true) {
            try {
                System.out.println(INPUT_LOTTO_NUMBERS_MESSAGE);
                final String answerLottoNumbers = scanner.next();
                return new Lotto(Splitter.split(answerLottoNumbers));
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
    }

    /**
     * 보너스 번호 추가 입력
     *
     * @return
     */
    public LottoNumber inputBonusNumber() {
        while (true) {
            try {
                System.out.println(INPUT_BONUS_NUMBER);
                return new LottoNumber(scanner.nextInt());
            } catch (final InputMismatchException e) {
                System.out.println(INPUT_INT_ERROR_MESSAGE);
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
    }

    /**
     * 로또번호 수동 갯수
     *
     * @return
     */
    public int inputManualLottoCount() {
        while (true) {
            try {
                System.out.println(INPUT_MANUAL_LOTTO_NUMBERS_COUNT_MESSAGE);
                final int manualLottoCount = scanner.nextInt();
                validateNegativeInt(manualLottoCount);
                return manualLottoCount;
            } catch (final InputMismatchException e) {
                System.out.println(INPUT_INT_ERROR_MESSAGE);
            } catch (final IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine();
            }
        }
    }

    private void validateNegativeInt(final int manualLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException(INPUT_NEGATIVE_INT_ERROR_MESSAGE);
        }
    }

    /**
     * 수동 로또 번호 입력
     *
     * @param manualLottoCount
     * @return
     */
    public List<String> inputManualLottoNumbers(final int manualLottoCount) {
        while (true) {
            try {
                System.out.println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);
                final List<String> manualLottos = new ArrayList<>(manualLottoCount);
                for (int i = 0; i < manualLottoCount; i++) {
                    manualLottos.add(scanner.next());
                }
                return manualLottos;
            } catch (final InputMismatchException e) {
                System.out.println(INPUT_INT_ERROR_MESSAGE);
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine();
            }
        }

    }
}
