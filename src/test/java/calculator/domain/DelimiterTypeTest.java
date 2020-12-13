package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("구분자 타입을 확인하는 테스트")
class DelimiterTypeTest {

    @DisplayName("커스텀 구분자 타입 반환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"//&\n1&2&3"})
    void findCustomDelimiterTypeByExpressionTest(String input) {
        // When
        DelimiterType delimiterType = DelimiterType.findByExpression(input);

        // Then
        assertThat(delimiterType).isEqualTo(DelimiterType.CUSTOM);
    }

    @DisplayName("기본 구분자 타입 반환 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void findDefaultDelimiterTypeByExpressionTest(String input) {
        // When
        DelimiterType delimiterType = DelimiterType.findByExpression(input);

        // Then
        assertThat(delimiterType).isEqualTo(DelimiterType.DEFAULT);
    }
}
