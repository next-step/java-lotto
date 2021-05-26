package lotto.model;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTicketTest {

	private LottoTicket lottoTicket;
	private List<LottoNumbers> inputLottoNumbers;

	@BeforeEach
	public void setup() {
		inputLottoNumbers = asList(
			LottoNumbers.of(asList(5, 12, 26, 2, 29, 42)),
			LottoNumbers.of(asList(5, 6, 13, 40, 26, 41)),
			LottoNumbers.of(asList(5, 1, 2, 40, 6, 26)),
			LottoNumbers.of(asList(1, 5, 6, 26, 34, 40)),
			LottoNumbers.of(asList(1, 5, 6, 7, 2, 40))
		);

		lottoTicket = new LottoTicket(inputLottoNumbers);
	}

	@Test
	@DisplayName("0개 이상의 LottoNumbers 로 LottoNumbersGroup 을 만들 수 있다.")
	public void createLottoNumbersGroupTest() {
		List<List<Integer>> expected = inputLottoNumbers.stream()
			.map(LottoNumbers::getNumbers)
			.collect(Collectors.toList());

		assertThat(lottoTicket.getLottoNumbersGroup()).isEqualTo(expected);
	}

	@ParameterizedTest
	@DisplayName("당첨 번호와 보너스 숫자에 따라 로또 그룹의 등수 별 당첨 수가 나온다.")
	@CsvSource(value = {"MISS:0", "FOURTH:1", "THIRD:1", "SECOND:1", "FIRST:1"}, delimiter = ':')
	public void resultTest(LottoRank lottoRank, int expectedCount) {
		LottoNumbers winningNumbers = LottoNumbers.of(asList(1, 5, 40, 2, 6, 26));
		LottoNumber bonusNumber = LottoNumber.of(7);

		LottoResult lottoResult = lottoTicket.match(WinningNumbers.of(winningNumbers, bonusNumber));

		assertThat(lottoResult.count(lottoRank)).isEqualTo(expectedCount);
	}

	@Test
	@DisplayName("여러 가지 방법들로 로또 티켓을 만들어 낼 수 있다.")
	public void createTest() {
		List<List<Integer>> inputNumbers = asList(asList(1, 2, 3, 4, 5, 6));

		LottoTicket lottoTicket = LottoTicket.create(() -> inputLottoNumbers, new NumbersInputStrategy(inputNumbers));

		List<LottoNumbers> expected = new ArrayList<>(inputLottoNumbers);
		expected.add(LottoNumbers.of(1, 2, 3, 4, 5, 6));
		assertThat(lottoTicket.getLottoNumbers()).isEqualTo(expected);
	}
}
