package lotto.controller;

import lotto.domain.LottoShop;
import lotto.view.InputView;

public class LottoController {
	public static void main(String[] args) {
		int ticketQuantity = new LottoShop().sellTicket(
			new InputView().inputTotalAmount()
		);
	}
}
