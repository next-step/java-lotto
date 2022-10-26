package step2.model.lotto;

import static java.util.stream.IntStream.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Lottos implements Iterable<Lotto>{

	private final List<Lotto> lottos;

	public Lottos(int count) {
		this.lottos = generateLottos(count);
	}

	public List<Lotto> generateLottos(int count) {
		return range(0, count)
			.mapToObj(i -> new Lotto()).collect(Collectors.toList());
	}

	public HashMap<Integer, Integer> getMatchCountMap(Lotto winningLotto) {
		HashMap<Integer, Integer> countMap = new HashMap<>();
		this.lottos.forEach(lotto -> {
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
