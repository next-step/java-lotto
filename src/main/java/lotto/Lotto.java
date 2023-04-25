package lotto;

import lotto.domain.Issuer;
import lotto.domain.Winners;
import lotto.present.InputPresent;
import lotto.present.OutputPresent;
import lotto.present.dto.IncomePresentDTO;
import lotto.present.dto.WinnerPresentDTO;

public class Lotto {


    public static void main(String[] args) {
        InputPresent inputPresent = new InputPresent();
        OutputPresent outputPresent = new OutputPresent();
        Issuer issuer = new Issuer();

        issuer.purchaseTickets(inputPresent.purchaseCount());
        outputPresent.presentTickets(issuer.purchasedTickets());

        Winners winners = issuer.makeWinners(inputPresent.winningNumbers());
        outputPresent.presentWinners(new WinnerPresentDTO(winners));
        outputPresent.presentIncome(new IncomePresentDTO(winners));
    }
}
