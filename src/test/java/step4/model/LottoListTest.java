package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.util.LottoGenerator;
import step4.util.RandomLottoGenerator;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoListTest {
	LottoList lottoList;
	LottoGenerator lottoGenerator = new RandomLottoGenerator();

	@BeforeEach
	void beforeEach() {
		Money money = new Money(2000);
		lottoList = new LottoList(money, lottoGenerator, List.of("1,2,3,4,5,6"));
	}

	@Test
	@DisplayName("수동으로 생성한 번호는 생성된 로또 리스트에 포함되어야 한다.")
	void generateTest() {
		assertTrue(lottoList.getLottoList().contains(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
	}
}