package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoFactory {
	private static final int LOTTO_START = 1;
	private static final int LOTTO_END = 45;
	private static final int LOTTO_PICK_START = 0;
	private static final int LOTTO_PICK_END = 5;
	private List<Integer> balls = new ArrayList<>();

	public LottoFactory() {
		for (int i = LOTTO_START; i <= LOTTO_END ; i++) {
			this.balls.add(i);
		}
	}

	public Set<Integer> getRandomLotto() {
		Set<Integer> shuffle = new TreeSet<>();
		Collections.shuffle(balls);

		for (int i = LOTTO_PICK_START; i <= LOTTO_PICK_END; i++) {
			shuffle.add(balls.get(i));
		}

		return shuffle;
	}

	public List<Integer> getBalls() {
		return balls;
	}
}
