package step2;

public class Game {
	public static void start(int input) {
		Print.inputAmount();
		int amount = validAmount(input);
	}

	private static int validAmount(int inputAmount) {
		if (inputAmount < 1000) {
			throw new IllegalArgumentException("최소 금액은 1000원 입니다");
		}
		return inputAmount;
	}
}
