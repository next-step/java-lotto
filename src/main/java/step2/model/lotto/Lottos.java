package step2.model.lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lottos implements Iterable<Lotto>{

	private List<Lotto> lottos;

	public Lottos() {
	}

	public Lottos(int count) {
		this.lottos = generateLottos(count);
	}

	public List<Lotto> generateLottos(int count) {
		List<Lotto> list = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			list.add(new Lotto());
		}
		return list;
	}

	public HashMap<Integer, Integer> getMatchCountMap(Lotto winningLotto) {
		HashMap<Integer, Integer> countMap = new HashMap<>();
		lottos.forEach(lotto -> {
			countMap.put(this.lottos.indexOf(lotto), 0);
			countMap.computeIfPresent(lotto.getMatchCount(winningLotto.getNumbers()), (matchCount, cnt) -> cnt + 1);
		});
		return countMap;
	}

	public int size() {
		return this.lottos.size();
	}

	@Override
	public Iterator<Lotto> iterator() {
		return lottos.iterator();
	}

	@Override
	public void forEach(Consumer<? super Lotto> action) {
		Iterable.super.forEach(action);
	}
}
