package com.woowahan.lotto.view;

import java.util.Scanner;

import com.woowahan.lotto.constant.Message;

public class PurchaseInputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static String getPurchaseAmount() {
		System.out.println(Message.MSG_REQUEST_PURCHASE_AMOUNT);
		return scanner.nextLine();
	}

}
