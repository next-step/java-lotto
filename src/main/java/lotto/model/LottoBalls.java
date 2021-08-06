package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoBalls {

	private final List<Integer> lottoBalls;

	public LottoBalls(List<Integer> lottoBalls) {
		this.lottoBalls = new ArrayList<>(lottoBalls);
	}

	public List<Integer> getLottoBalls() {
		return lottoBalls;
	}
}
