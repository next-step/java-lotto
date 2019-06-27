package lotto.view.out;

public class ConsolePrinter implements MessagePrinter {

	@Override
	public void print(String message) {
		System.out.println(message);
	}
}
