package lotto.collections;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.collections.LottoTicket;
import lotto.domain.LottoNumber;
import lotto.util.AutoLottoNumberGenerator;

public class LottoTicketTest {

	AutoLottoNumberGenerator autoLottoNumberGenerator = new AutoLottoNumberGenerator();

	@DisplayName("로또 티켓 하나는 6개의 숫자를 들고 있다.")
	@Test
	void 로또_티켓의_숫자는_6가지이다() {
		final int LOTTO_NUMBER_SIZE = 6;
		assertThat(new LottoTicket(autoLottoNumberGenerator.pickList()).getLottoNumbers().size())
			.isEqualTo(LOTTO_NUMBER_SIZE);
	}

	@DisplayName("로또 티켓의 숫자는 각각 오름차순 순서대로 인덱스가 정렬되어 있다.")
	@Test
	void 로또_티켓의_숫자는_오름차순으로_정렬되어_있다() {
		LottoTicket lottoTicket = new LottoTicket(autoLottoNumberGenerator.pickList());
		List<LottoNumber> lottoNumberListOriginal = lottoTicket.getLottoNumbers();
		List<LottoNumber> lottoNumberListCopy = new ArrayList<>(lottoNumberListOriginal);
		lottoNumberListCopy.sort(Comparator.comparing(LottoNumber::getNumber));
		assertThat(lottoNumberListOriginal.equals(lottoNumberListCopy)).isTrue();
	}

	@DisplayName("로또 티켓 하나는 로또 번호를 들고 있다.")
	@CsvSource({"1,2,3,4,5,6", "3,5,6,7,2,4", "8,2,3,5,6,9"})
	@ParameterizedTest
	void 로또_티켓은_로또_번호를_들고_있다(String valueList) {
		List<LottoNumber> lottoNumbers = Arrays.stream(valueList.split(","))
			.map(String::trim)
			.map(Integer::valueOf)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
		assertThat(lottoTicket.getLottoNumbers().stream().map(LottoNumber::getNumber).findFirst())
			.isEqualTo(lottoNumbers.stream().map(LottoNumber::getNumber).findFirst());
	}
}
