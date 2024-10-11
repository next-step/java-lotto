package lotto;

import java.util.Scanner;

public class InputView {
    public static final int LOTTO_TICKET_PRICE = 1000;
    private static InputValidator inputValidator = new InputValidator();

    public int getInputAndPrint() {
        print("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        String inputPrice = scanner.nextLine();
        inputValidator.validate(inputPrice);

        int lottoTicketCount = getLottoTicketCount(inputPrice);
        print(lottoTicketCount + "개를 구매했습니다.");

        return lottoTicketCount;
    }

    private int getLottoTicketCount(String inputPrice) {
        return Integer.parseInt(inputPrice) / LOTTO_TICKET_PRICE;
    }

    public void print(String message) {
        System.out.println(message);
    }
}
