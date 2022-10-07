package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRaffle;
import lotto.domain.UserInput;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Set;

public class LottoController {

    public void lottoMachine() {
        UserInput userInput = new UserInput(new Input().price());
        System.out.println(userInput.count() + "개 구매되었습니다.");

        List<Set> lottoTickets = new Lotto().lotto(userInput);
        new Output().printLottoTickets(lottoTickets);

        Set<Integer> raffleNumber = new LottoRaffle().getRaffleNumber();
        System.out.printf("당첨번호는 %s 입니다!!!", raffleNumber);
    }
}
