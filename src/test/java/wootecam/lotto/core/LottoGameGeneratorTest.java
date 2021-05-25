package wootecam.lotto.core;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import wootecam.lotto.exception.LottoException;
import wootecam.lotto.model.Lotto;
import wootecam.lotto.model.LottoCount;
import wootecam.lotto.model.LottoNumber;
import wootecam.lotto.model.WinningLotto;

public class LottoGameGeneratorTest {

	private LottoGameGenerator lottoGameGenerator;

	@BeforeEach
	void setup() {
		lottoGameGenerator = new LottoGameGenerator(new AutomaticLottoGenerator());
	}

	@ParameterizedTest
	@ValueSource(strings = {"5000", "2000", "15000"})
	@DisplayName("입력된 금액에 맞는 로또 수를 생성하는지 테스트")
	void test_로또구매수만큼_로또생성확인(String input) {
		LottoCount lottoCount = new LottoCount(input);
		List<Lotto> lottos = lottoGameGenerator.getLottos(lottoCount);
		assertThat(lottos.size()).isEqualTo(lottoCount.getCount());
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4,5,6:9"}, delimiter = ':')
	@DisplayName("정상적인 입력에 대한 당첨번호테스트")
	void test_당첨번호테스트(String input, String bonusInput) {
		WinningLotto winningLotto = lottoGameGenerator.getWinningLotto(input, bonusInput);
		assertThat(winningLotto.contains(new LottoNumber(1))).isTrue();
		assertThat(winningLotto.contains(new LottoNumber(2))).isTrue();
		assertThat(winningLotto.contains(new LottoNumber(3))).isTrue();
		assertThat(winningLotto.contains(new LottoNumber(4))).isTrue();
		assertThat(winningLotto.contains(new LottoNumber(5))).isTrue();
		assertThat(winningLotto.contains(new LottoNumber(6))).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,3,4,5:9", "4,5,6:9"}, delimiter = ':')
	@DisplayName("당첨번호 입력이 잘못된경우 오류반환 확인")
	void test_당첨번호오류테스트1(String input, String bonusInput) {
		assertThatThrownBy(() -> {
			lottoGameGenerator.getWinningLotto(input, bonusInput);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("로또 번호는 6개여야 합니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,c,4,5,3:9", "a,b,c,d,e,f:9"}, delimiter = ':')
	@DisplayName("당첨번호 입력이 잘못된경우 오류반환 확인 - 문자입력")
	void test_당첨번호오류테스트2(String input, String bonusInput) {
		assertThatThrownBy(() -> {
			lottoGameGenerator.getWinningLotto(input, bonusInput);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("정수형이 아닙니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {"12,2,3,4,555,5:9", "48,282,393,222,444,555:9"}, delimiter = ':')
	@DisplayName("당첨번호 입력이 잘못된경우 오류반환 확인 - 범위초과")
	void test_당첨번호오류테스트3(String input, String bonusInput) {
		assertThatThrownBy(() -> {
			lottoGameGenerator.getWinningLotto(input, bonusInput);
		}).isInstanceOf(LottoException.class)
			.hasMessageContaining("로또 번호는 1~45만 가능합니다.");
	}
}
