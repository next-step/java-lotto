package step3.model.lotto;

import static java.util.stream.IntStream.*;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Lottos implements Iterable<Lotto> {

	private List<Lotto> lottos;

	public Lottos(int count) {
		this.lottos = generateLottos(count);
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> generateLottos(int count) {
		return range(0, count)
			.mapToObj(i -> new Lotto()).collect(Collectors.toList());
	}

	public Lottos addAll(Lottos temp) {
		this.lottos.addAll(temp.lottos);
		return new Lottos(this.lottos);
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
