package lotto;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		Lotto lotto = new Lotto(model);
		while (lotto.isRunning()) {
			lotto.run();
		}
	}

}
