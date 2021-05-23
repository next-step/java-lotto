package com.nextstep.lotto.lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@DisplayName("로또를 생성하면 로또번호가 생성되어 저장되는지 테스트")
	@Test
	void 로또를_생성하면_로또번호가_생성되어_저장되는지_테스트() {
		Lotto lotto = new Lotto();
		assertThat(lotto.getLottoNumbers().isEmpty()).isFalse();
	}

	@DisplayName("로또가 6개의 로또 번호를 가지는지 테스트")
	@Test
	void 로또가_6개의_로또넘버를_가지는지_테스트() {
		Lotto lotto = new Lotto();
		assertThat(lotto.size()).isEqualTo(6);
	}

	@DisplayName("랜덤한 중복되지 않는 숫자를 발생시키는지 테스트")
	@Test
	void 랜덤한_중복되지않는_숫자를_발생새키는지_테스트() {
		Lotto lotto = new Lotto();
		List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
		Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
		assertThat(lottoNumbers.size() == lottoNumberSet.size()).isTrue();
	}
}
