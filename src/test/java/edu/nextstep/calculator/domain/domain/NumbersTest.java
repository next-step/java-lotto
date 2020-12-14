package edu.nextstep.calculator.domain.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.nextstep.calculator.domain.Number;
import edu.nextstep.calculator.domain.Numbers;

@DisplayName("Numbers: Number 클래스 목록에 대한 일급 콜렉션")
class NumbersTest {

	@DisplayName("생성자: 문자열 목록을 받아 Numbers 객체를 정상적으로 생성하여 리턴함.")
	@Test
	public void generate() {
		Numbers numbers = new Numbers(new String[] {"1", "2", "3"});
		assertThat(numbers)
			.isNotNull()
			.isInstanceOf(Numbers.class)
			.hasFieldOrPropertyWithValue("numbers",
				new Number[] {Number.createFromString("1"), Number.createFromString("2"), Number.createFromString("3")});
	}

	@DisplayName("sumAll: 인스턴스 변수 numbers 내 모든 Number 객체를 더한 후 원시값을 리턴함.")
	@Test
	void sumAll() {
		Numbers numbers = new Numbers(new String[] {"1", "2", "3"});
		assertThat(numbers.sumAll()).isEqualTo(6);
	}
}