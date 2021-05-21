package lotto.views;

import lotto.enums.Message;

public final class Display {

	public static void show(Message message) {
		System.out.println(message.toString());
	}

	public static void error(String message) {
		System.out.println(message);
	}
}
