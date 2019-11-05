package lotto;

import lotto.controller.LottoController;

public class Main {

	public static void main(String[] args) {
		try {
			LottoController.buyLottoAndLookUpPrizes();
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(String.format("입력한 값을 확인해주세요! Error message: %s", e));
		}
	}

}
