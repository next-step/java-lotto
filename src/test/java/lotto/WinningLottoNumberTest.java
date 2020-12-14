package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import stringaddcalculator.domain.StringAddCalculator;

/**
 * @author : byungkyu
 * @date : 2020/12/14
 * @description :
 **/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WinningLottoNumberTest {

	@Order(1)
	@DisplayName("1. 당첨 번호는 빈 값을 입력할 수 없다.")
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = {""})
	public void inputCannotNullOrEmpty(String arg) {

		assertThatThrownBy(() -> {
			WinningLottoNumber winningLottoNumber = new WinningLottoNumber(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("지난 주 당첨 번호를 입력해 주세요.");
	}

	@Order(2)
	@DisplayName("2. 당첨 번호는 서로 다른 숫자만 입력할 수 있다.")
	@ParameterizedTest
	@ValueSource(strings = {"1, 2, 3, 4, 5, 5"})
	public void inputCannotDuplicate(String arg) {

		assertThatThrownBy(() -> {
			WinningLottoNumber winningLottoNumber = new WinningLottoNumber(arg);
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("서로 다른 6개의 당첨 번호를 입력해 주세요.");
	}

}
