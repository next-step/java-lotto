package step2;

public class Main {
	public static void main(String[] args) {
		Print.inputAmount();
		int input = InputView.input();
		Print.amount(input / 1000);
		Game.start(input);
	}
}
