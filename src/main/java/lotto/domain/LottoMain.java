package lotto.domain;

import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        try {
            int money = InputView.getMoneyToBuyLotto();
            int numberOfTicket = LottoTickets.countTicketNumberByMoney(money);
            // List<Lotto> generatedLottoNumbers = LottoGenerator.generateLottoNumbers(numberOfTicket);
            // LottoTickets purchasedTickets = new LottoTickets(generatedLottoNumbers);
            // 무작위 로또를 생성해 로또티켓 객체에 생성자 주입

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
