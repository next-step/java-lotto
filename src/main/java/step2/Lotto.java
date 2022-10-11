package step2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	private List<Integer> balls = new ArrayList<>();

	public Lotto() {
		for (int i = 1; i <= 45 ; i++) {
			this.balls.add(i);
		}
	}

	public Set<Integer> getRandomLotto(int randomStart) {
		Set<Integer> shuffle = new TreeSet<>();
		Collections.shuffle(balls);

		for (int i = randomStart; i <= randomStart + 5; i++) {
			shuffle.add(balls.get(i));
		}

		return shuffle;
	}

	public List<Integer> getBalls() {
		return balls;
	}
}
