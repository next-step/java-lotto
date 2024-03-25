package lotto.view;

import static lotto.error.ErrorMessage.ILLEGAL_STATE;
import static lotto.error.ErrorMessage.INVALID_FORMAT;
import static lotto.error.ErrorMessage.INVALID_INPUT_EMPTY;
import static lotto.error.ErrorMessage.INVALID_INPUT_TYPE_INT;
import static lotto.error.ErrorMessage.UN_EXPECTED_ERROR;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static int inputPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            scanner.nextLine();
            return Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(INVALID_FORMAT.getMessage());
        } catch (InputMismatchException e) {
            throw new InputMismatchException(INVALID_INPUT_TYPE_INT.getMessage());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(INVALID_INPUT_EMPTY.getMessage());
        } catch (IllegalStateException e) {
            throw new IllegalStateException(ILLEGAL_STATE.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException(UN_EXPECTED_ERROR.getMessage(), e);
        }
    }
}
