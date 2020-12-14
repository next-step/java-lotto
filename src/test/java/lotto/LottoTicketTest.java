package lotto;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LottoTicketTest {
	LottoTicket lottoTicket;

	@BeforeEach
	void setUp() {
		LottoNumber lottoNumber1 = new LottoNumber(1);
		LottoNumber lottoNumber2 = new LottoNumber(12);
		LottoNumber lottoNumber3 = new LottoNumber(13);
		LottoNumber lottoNumber4 = new LottoNumber(14);
		LottoNumber lottoNumber5 = new LottoNumber(15);
		LottoNumber lottoNumber6 = new LottoNumber(16);

		lottoTicket = new LottoTicket(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4,lottoNumber5,lottoNumber6);
	}

	@Order(1)
	@DisplayName("1. 로또 한 장은 6개의 숫자로 이루어져 있다.")
	@Test
	void lottoTicketNumberCountIsSix() {
		assertThat(lottoTicket.get().size()).isEqualTo(6);
	}

	@Order(2)
	@DisplayName("1.2 로또 한 장은 6개의 숫자로 이루어져 있다. 6개 미만 불가")
	@Test
	void lottoNumberIsContainSixNumbersAndCannotLowerSix() {
		LottoNumber lottoNumber1 = new LottoNumber(1);
		LottoNumber lottoNumber2 = new LottoNumber(12);
		LottoNumber lottoNumber3 = new LottoNumber(13);
		LottoNumber lottoNumber4 = new LottoNumber(14);
		LottoNumber lottoNumber5 = new LottoNumber(15);

		assertThatThrownBy(() -> {
			lottoTicket = new LottoTicket(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4,lottoNumber5);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 번호는 6개를 입력할 수 있습니다.");

	}

	@Order(3)
	@DisplayName("1.3 로또 한 장은 6개의 숫자로 이루어져 있다. 6개 초과 불가")
	@Test
	void lottoNumberIsContainSixNumbersAndCannotOverSix() {
		LottoNumber lottoNumber1 = new LottoNumber(1);
		LottoNumber lottoNumber2 = new LottoNumber(12);
		LottoNumber lottoNumber3 = new LottoNumber(13);
		LottoNumber lottoNumber4 = new LottoNumber(14);
		LottoNumber lottoNumber5 = new LottoNumber(15);
		LottoNumber lottoNumber6 = new LottoNumber(17);
		LottoNumber lottoNumber7 = new LottoNumber(18);

		assertThatThrownBy(() -> {
			lottoTicket = new LottoTicket(lottoNumber1, lottoNumber2, lottoNumber3, lottoNumber4,lottoNumber5, lottoNumber6, lottoNumber7);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 번호는 6개를 입력할 수 있습니다.");

	}
}
