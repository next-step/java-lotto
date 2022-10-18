package lotto;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    private static final String FIRST_MSG = "구입금액을 입력해 주세요";
    private static final String TICKET_AMT_MSG = "개를 구매했습니다.";

    public ClientInput getClientInput(){
        System.out.println(FIRST_MSG);
        int priceInput = scanner.nextInt();
        ClientInput result = ClientInput.builder()
                .priceInput(priceInput)
                .build();
        System.out.println(result.getTicketAmt() + TICKET_AMT_MSG);
        return result;
    }
}
