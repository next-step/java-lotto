package lotto.view;

import lotto.model.LottoTickets;

import java.util.*;

public class InputView {
    Scanner input;
    private final String inputMoney = "구입금액을 입력해 주세요.";
    private final String inputPreNumber = "지난 주 당첨 번호를 입력해 주세요.";

    public InputView() {
        input = new Scanner(System.in);
    }

    public int buyLotto() {
        System.out.println(inputMoney);
        int money = input.nextInt();
        input.nextLine();

        return money;
    }

    public void printLottoNumbers(LottoTickets lottoTickets) {
        for (int i = 0; i < lottoTickets.getTicketCount(); i++) {
            System.out.println(lottoTickets.oneOf(i).getTicketNumbers());
        }
    }

    public Set<Integer> inputPreWinningNumber() {
        System.out.println(inputPreNumber);
        String preWinningNumber = input.nextLine();
        String[] numbers = preWinningNumber.split(",");
        Set<Integer> preNumbers = new HashSet<>();

        for (String number : numbers) {
            preNumbers.add(Integer.parseInt(number.trim()));
        }
        return preNumbers;
    }
}
