package lotto.view;

import lotto.model.LottoTickets;

import java.util.*;

public class InputView {
    private Map<String, String> inputPrints;
    Scanner input;

    public InputView() {
        inputPrints = new HashMap<>();
        inputPrints.put("inputMoney", "구입금액을 입력해 주세요.");
        inputPrints.put("buyTickets", "개를 구매했습니다.");
        inputPrints.put("inputPreNumber", "지난 주 당첨 번호를 입력해 주세요.");
        input = new Scanner(System.in);
    }

    public int buyLotto(int ticketPrice) {
        System.out.println(inputPrints.get("inputMoney"));
        int price = input.nextInt();
        input.nextLine();
        int tickets = price / ticketPrice;
        System.out.println(tickets + inputPrints.get("buyTickets"));

        return tickets;

    }

    public void printLottoNumbers(LottoTickets lottoTickets) {
        for (int i = 0; i < lottoTickets.getTicketCount(); i++) {
            System.out.println(lottoTickets.oneOf(i).getTicketNumbers());
        }
    }

    public List<Integer> inputPreWinningNumber() {
        System.out.println(inputPrints.get("inputPreNumber"));
        String preWinningNumber = input.nextLine();
        String[] numbers = preWinningNumber.split(",");
        List<Integer> preNumbers = new ArrayList<>();

        for (String number : numbers) {
            preNumbers.add(Integer.parseInt(number.trim()));
        }
        return preNumbers;
    }
}
