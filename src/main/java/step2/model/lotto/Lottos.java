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
		// 로또의 숫자개수 만큼 해시맵을 생성
		HashMap<Integer, Integer> countMap = new HashMap<>();
		for (int matchCount = 1; matchCount < winningLotto.getNumbers().size() + 1; matchCount++) {
			countMap.put(matchCount, 0);
		}

		this.lottos.forEach(lotto -> {
			countMap.computeIfPresent(lotto.getMatchCount(winningLotto.getNumbers()), (matchCount, cnt) -> cnt + 1);
		});
		return countMap;
	}

	public int size() {
		return this.lottos.size();
	}

	public Lotto get(int index) {
		return this.lottos.get(index);
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
