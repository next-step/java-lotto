package step2.domain;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
	@Test
	@DisplayName("로또 번호 6자리인지 체크하는 테스트")
	public void lottoNumberCountTest() {
		List<LottoNumber> lottoNumberList = LottoNumber.asList("1,2,3,4,5,6,7");
		assertThatThrownBy(() -> {
			new Lotto(lottoNumberList);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("로또 번호 중복 체크하는 테스트")
	public void lottoNumberDistinctTest() {
		List<LottoNumber> lottoNumberList = LottoNumber.asList("1,2,3,6,5,6");
		assertThatThrownBy(() -> {
			new Lotto(lottoNumberList);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}