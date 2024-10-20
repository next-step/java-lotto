package lotto.ui.input;

import lotto.model.Lotto;
import lotto.model.Price;

import java.util.Scanner;

public class ConsoleInputView implements InputView{

    public static final String READ_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String READ_WINNING_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Price readPrice() {
        System.out.println(READ_PRICE_MESSAGE);
        return new Price(scanner.nextLine());
    }

    @Override
    public Lotto readWinningLotto() {
        System.out.println(READ_WINNING_LOTTO_MESSAGE);
        String text = scanner.nextLine();
        return new Lotto(text);
    }
}
