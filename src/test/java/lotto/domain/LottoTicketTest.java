package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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

		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(lottoNumber1);
		lottoNumbers.add(lottoNumber2);
		lottoNumbers.add(lottoNumber3);
		lottoNumbers.add(lottoNumber4);
		lottoNumbers.add(lottoNumber5);
		lottoNumbers.add(lottoNumber6);

		lottoTicket = new LottoTicket(lottoNumbers);
	}

	@Order(1)
	@DisplayName("1. 로또 한 장은 6개의 숫자로 이루어져 있다.")
	@Test
	void lottoTicketNumberCountIsSix() {
		assertThat(lottoTicket.get().size()).isEqualTo(6);
	}

	@Order(2)
	@DisplayName("2.1 로또 한 장은 6개의 숫자로 이루어져 있다. 6개 미만 불가")
	@Test
	void lottoNumberIsContainSixNumbersAndCannotLowerSix() {
		LottoNumber lottoNumber1 = new LottoNumber(1);
		LottoNumber lottoNumber2 = new LottoNumber(12);
		LottoNumber lottoNumber3 = new LottoNumber(13);
		LottoNumber lottoNumber4 = new LottoNumber(14);
		LottoNumber lottoNumber5 = new LottoNumber(15);

		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(lottoNumber1);
		lottoNumbers.add(lottoNumber2);
		lottoNumbers.add(lottoNumber3);
		lottoNumbers.add(lottoNumber4);
		lottoNumbers.add(lottoNumber5);

		assertThatThrownBy(() -> {
			lottoTicket = new LottoTicket(lottoNumbers);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 번호는 6개를 입력할 수 있습니다.");

	}

	@Order(3)
	@DisplayName("2.2 로또 한 장은 6개의 숫자로 이루어져 있다. 6개 초과 불가")
	@Test
	void lottoNumberIsContainSixNumbersAndCannotOverSix() {
		LottoNumber lottoNumber1 = new LottoNumber(1);
		LottoNumber lottoNumber2 = new LottoNumber(12);
		LottoNumber lottoNumber3 = new LottoNumber(13);
		LottoNumber lottoNumber4 = new LottoNumber(14);
		LottoNumber lottoNumber5 = new LottoNumber(15);
		LottoNumber lottoNumber6 = new LottoNumber(17);
		LottoNumber lottoNumber7 = new LottoNumber(18);

		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(lottoNumber1);
		lottoNumbers.add(lottoNumber2);
		lottoNumbers.add(lottoNumber3);
		lottoNumbers.add(lottoNumber4);
		lottoNumbers.add(lottoNumber5);
		lottoNumbers.add(lottoNumber6);
		lottoNumbers.add(lottoNumber7);

		assertThatThrownBy(() -> {
			lottoTicket = new LottoTicket(lottoNumbers);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 번호는 6개를 입력할 수 있습니다.");
	}

	@Order(3)
	@DisplayName("3 로또의 숫자들은 중복되지 않는다.")
	@Test
	void lottoNumbersCannotDuplicate() {
		LottoNumber lottoNumber1 = new LottoNumber(1);
		LottoNumber lottoNumber2 = new LottoNumber(1);
		LottoNumber lottoNumber3 = new LottoNumber(22);
		LottoNumber lottoNumber4 = new LottoNumber(33);
		LottoNumber lottoNumber5 = new LottoNumber(40);
		LottoNumber lottoNumber6 = new LottoNumber(42);

		List<LottoNumber> lottoNumbers = new ArrayList<>();
		lottoNumbers.add(lottoNumber1);
		lottoNumbers.add(lottoNumber2);
		lottoNumbers.add(lottoNumber3);
		lottoNumbers.add(lottoNumber4);
		lottoNumbers.add(lottoNumber5);
		lottoNumbers.add(lottoNumber6);

		assertThatThrownBy(() -> {
			lottoTicket = new LottoTicket(lottoNumbers);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("로또 번호는 중복될 수 없습니다.");
	}
}
