package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PurchaseStandByTest {

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@MethodSource("provideConstruction")
	void constructor(int price, int autoGameCount, List<String[]> manualNumbers) {
		assertThat(new PurchaseStandBy(price, manualNumbers)).isEqualTo(new PurchaseStandBy(price, manualNumbers, autoGameCount));
	}

	@DisplayName("purchase 메서드 테스트")
	@ParameterizedTest
	@MethodSource("providePurchase")
	void purchase(PurchaseStandBy purchaseStandBy, LottoGames lottoGames) {
		assertThat(purchaseStandBy.purchase()).isEqualTo(lottoGames);
	}


	static Stream<Arguments> provideConstruction() {
		return Stream.of(
				Arguments.of(1000, 1, Collections.EMPTY_LIST),
				Arguments.of(3000, 1, List.of(new String[]{"1","2","3","4","5","6"}, new String[]{"5","6","7","8","9","10"}))

		);
	}

	static Stream<Arguments> providePurchase() {

		List<String[]> gameNumbers = List.of(new String[]{"1", "2", "3", "4", "5", "6"}, new String[]{"5", "6", "7", "8", "9", "10"});

		PurchaseStandBy purchaseStandBy = new PurchaseStandBy(2000, gameNumbers);

		List<LottoGame> lottoGames = gameNumbers.stream().map(LottoGame::new).collect(Collectors.toList());

		return Stream.of(
				Arguments.of(purchaseStandBy, new LottoGames(lottoGames))
		);
	}
}
