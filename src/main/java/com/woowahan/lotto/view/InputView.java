package com.woowahan.lotto.view;

import java.util.List;
import java.util.Scanner;

import com.woowahan.lotto.constant.Message;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static String getPurchaseAmount() {
		System.out.println(Message.MSG_REQUEST_PURCHASE_AMOUNT);
		return scanner.nextLine();
	}

	public static String getWinNumber() {
		System.out.println(Message.MSG_REQUEST_LOTTO_WIN_NUMBER);
		return scanner.nextLine();
	}

	public static String getBonusNumber() {
		System.out.println(Message.MSG_REQUEST_LOTTO_BONUS_NUMBER);
		return scanner.nextLine();
	}

	public static List<String> getManualNumbers() {
		return null;
	}
}
