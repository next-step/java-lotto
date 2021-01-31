package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class KeyboardInputView implements InputView {

    private final Scanner scanner;

    public KeyboardInputView(final InputStream source) {
        this.scanner = new Scanner(source);
    }

    public int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public LottoTicket getWinningTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputText = scanner.nextLine();
        String[] winningTicketNumbers = inputText.split(", ");

        List<LottoNumber> lottoNumberList = Arrays
                .stream(winningTicketNumbers)
                .map(winningTicketNumber -> new LottoNumber(Integer.parseInt(winningTicketNumber)))
                .collect(Collectors.toList());
        return new LottoTicket(lottoNumberList);
    }

    public LottoNumber getBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        return new LottoNumber(bonusNumber);
    }
}
