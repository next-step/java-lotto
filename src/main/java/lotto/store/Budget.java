package lotto.store;

public class Budget {

	public Budget(int budget) {
		this.budget = budget;
	}

	private final int budget;

	public int get() {
		return budget;
	}
}
