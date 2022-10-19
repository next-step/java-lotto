package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoControllerTest {

	@Test
	@DisplayName("로또 한장의 일치여부를 확인한다.")
	void 반복_테스트() {
		LottoController lottoController = new LottoController();
		lottoController.startLotto();
	}

}
