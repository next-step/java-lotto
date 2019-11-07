package lotto;

import lotto.controller.LottoController;

import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		try {
			LottoController.buyLottoAndLookUpPrizes();
		} catch (IllegalArgumentException | IllegalStateException e) {
			System.out.println(String.format("입력한 값을 확인해주세요! Error message: %s", e));
		} catch (InputMismatchException e) {
			System.out.println("숫자나 문자를 알맞게 입력하신 것 맞나요 ...?");
		}
	}

}
