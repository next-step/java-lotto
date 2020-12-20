package step2.view;

import java.util.List;

import step2.domain.Lotto;

public class OutputView {

	public void printLottos(final List<Lotto> lottos) {
		lottos.forEach(System.out::println);
	}

}
