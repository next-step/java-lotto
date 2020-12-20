package lotto.view;

import static lotto.domain.LottoTickets.*;

import java.util.List;

import lotto.domain.ManualNumbers;

/**
 * @author : byungkyu
 * @date : 2020/12/18
 * @description :
 **/
public class BuyInfo {

	private Cash cash;
	private ManualNumbers manualNumbers;

	public BuyInfo(int inputCash, List<String> manualNumbers) {
		this.cash = new Cash(inputCash);
		this.manualNumbers = new ManualNumbers(manualNumbers);
	}

	public static void validateManualLottoCount(int cash, int manualLottoCount) {
		if(manualLottoCount * LOTTO_TICKET_PRICE > cash) throw new IllegalArgumentException("수동으로 구매할 로또 수가 구입금액 한도를 벗어났습니다.");
	}

	public Cash getCash() {
		return cash;
	}

	public ManualNumbers getManualNumbers() {
		return manualNumbers;
	}

	public int getAutoAutoTicketCount() {
		return (cash.getAmount() / LOTTO_TICKET_PRICE) - manualNumbers.getCount();
	}
}
