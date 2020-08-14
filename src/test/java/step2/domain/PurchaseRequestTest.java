package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseRequestTest {

	@DisplayName("객체 생성 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1000:1", "5000:5", "10000:10"}, delimiter = ':')
	void constructor(int price, int count) {
		assertThat(new PurchaseRequest(price)).isEqualTo(new PurchaseRequest(price, count));
	}

	@DisplayName("새로 만들어진 게임의 숫자가 기대값과 같은가")
	@ParameterizedTest
	@CsvSource(value = {"1000:1", "5000:5", "10000:10"}, delimiter = ':')
	void purchase(int price, int count) {
		assertThat(new PurchaseRequest(price).purchase().getGameSize()).isEqualTo(count);
	}
}
