package lotto.domain;

import lotto.domain.lotto.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("LottoIssueRequest 클래스 테스트")
public class LottoIssueRequestTest {

    @DisplayName("LottoIssueRequest 객체를 생성할 수 있다.")
    @Test
    void create() {
        Price price = new Price(1000);
        List<String> manualNumberStrings = Arrays.asList("8,21,23,41,42,43", "3,5,11,16,32,38");
        assertThatCode(() -> new LottoIssueRequest(price, manualNumberStrings))
                .doesNotThrowAnyException();
    }
}
