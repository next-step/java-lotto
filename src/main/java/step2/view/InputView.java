package step2.view;

import step2.dto.LottoWinningCheckRequestDto;
import step2.dto.LottoCreationRequestDto;

import java.util.Scanner;

public final class InputView {

    private final Scanner scanner;
    private static InputView instance;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static final InputView getInstance() {
        if (isInstanceNull()) {
            instance = new InputView();
        }
        return instance;
    }

    private static final boolean isInstanceNull() {
        return instance == null;
    }

    private final int inputMoneyByClient() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.valueOf(scanner.nextLine());
    }

    private final String inputLottoNumbersByClient() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public final LottoCreationRequestDto getLottoCreationRequestDto() {
        return LottoCreationRequestDto.newInstance(inputMoneyByClient());
    }

    public final LottoWinningCheckRequestDto getLottoConfirmationRequestDto() {
        return LottoWinningCheckRequestDto.newInstance(inputLottoNumbersByClient());
    }

}
