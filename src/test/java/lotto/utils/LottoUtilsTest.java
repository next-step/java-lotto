package lotto.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoUtilsTest {

	@Test
	@DisplayName("문자열 로또를 로또로 변환시키는 테스트")
	public void getStringToLotto() {
		String lottoString = "1, 2, 3, 4, 5, 6";
		Lotto lotto = LottoUtils.mapStringToLotto(lottoString);
		assertThat(lotto).isNotNull();
		assertThat(lotto.toString()).isEqualTo("[" + lottoString + "]");
	}

	@Test
	@DisplayName("문자열 리스트 로또를 로또로 변환시키는 테스트")
	public void getStringListToLottos() {
		List<String> lottoStringList = new ArrayList<>();
		lottoStringList.add("1, 2, 3, 4, 5, 6");
		lottoStringList.add("4, 10, 25, 40, 45, 1");
		lottoStringList.add("23, 4 ,2, 30, 1, 5");
		Lottos lottos = LottoUtils.mapStringListToLottos(new Lottos(), lottoStringList);
		assertThat(lottos.getSize()).isEqualTo(3);
	}
}
