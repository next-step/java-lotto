package lotto.view;

import lotto.domain.Message;

public class OutputView {

	public static void printLottoCount(int count){
		System.out.println(count + Message.PRINT_NUMBER_OF_LOTTO_PURCHASED);
	}
}
