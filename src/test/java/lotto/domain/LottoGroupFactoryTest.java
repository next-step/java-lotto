package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGroupFactoryTest {

	@DisplayName("자동로또 생성")
	@Test
	void When_GivenAutoSize_CreatedSameQuantityLotto() {
		List<Lotto> autoLottoGroup = LottoGroupFactory.createAuto(5);

		assertThat(autoLottoGroup.size()).isEqualTo(5);
	}

	@DisplayName("자동로또를 0개 생성하는 경우 빈 컬레션 생성")
	@Test
	void When_Given0_LottoGroupIsEmpty() {
		List<Lotto> autoLottoGroup = LottoGroupFactory.createAuto(0);

		assertThat(autoLottoGroup.isEmpty()).isTrue();
	}

	@DisplayName("수동로또 생성")
	@Test
	void When_GivenManualSize_CreatedSameQuantityLotto() {
		List<Lotto> manualLottoGroup = LottoGroupFactory.createManual(List.of(
			"1,2,3,4,5,6",
			"42,12,7,5,3,28"
		));

		assertThat(manualLottoGroup.size()).isEqualTo(2);
	}

	@DisplayName("수동로또를 0개 생성하는 경우 빈 컬레션 생성")
	@Test
	void name() {
		List<Lotto> manualLottoGroup = LottoGroupFactory.createManual(Collections.emptyList());

		assertThat(manualLottoGroup.isEmpty()).isTrue();
	}
}
