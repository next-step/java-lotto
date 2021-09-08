package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WalletTest {
	private Wallet wallet;
	private final List<Numbers> numbersList = new ArrayList<>();

	@BeforeEach
	void init() {
		wallet = new Wallet(10000);
		List<Number> numbers = Stream.of(1, 2, 3, 4, 5, 6)
			.map(Number::new)
			.collect(Collectors.toList());
		numbersList.add(new Numbers(numbers));
	}

	@DisplayName(value = "구입 금액에 해당하는 로또 개수를 반환")
	@Test
	void countLottoToBuy() {
		int count = wallet.numberOfThingsToBuy();
		assertThat(count).isEqualTo(10);
	}

	@DisplayName(value = "남아있는 금액에 해당하는 로또를 자동으로 구매")
	@Test
	void buyLottoByAuto() {
		Lottos lottos = wallet.buyLottoByAuto();
		int result = lottos.getNumberOfLottos();
		assertThat(result).isEqualTo(10);
	}

	@DisplayName(value = "로또를 수동으로 구매")
	@Test
	void buyLottoByManual() {
		Lottos lottos = wallet.buyLottoByManual(numbersList);
		int result = lottos.getNumberOfLottos();
		assertThat(result).isEqualTo(1);
	}
}
