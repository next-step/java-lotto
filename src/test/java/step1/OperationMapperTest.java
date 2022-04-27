package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "연산 전략 매퍼 테스트")
class OperationMapperTest {

    private static final OperationMapper OPERATION_MAPPER = new OperationMapper();

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @CsvSource(value = {"'+', true", "'-', true", "'*', true", "'/', true", "'앗', false"})
    void 주어진_문자열이_연산자인지_판단(String input, boolean result) {

        boolean isOperator = OPERATION_MAPPER.isOperator(input);

        assertThat(isOperator).isEqualTo(result);
    }

    @ParameterizedTest(name = "{displayName} -> [{index}] : {arguments}")
    @EnumSource(Operator.class)
    void 입력_문자열에_매핑되는_연산이_있는_경우_연산_전략을_가져옴(Operator operator) {
        String input = operator.getValue();

        assertThat(OPERATION_MAPPER.getOperationStrategy(input)).isEqualTo(operator.getOperationStrategy());
    }

    @Test
    void 입력_문자열에_매핑되는_연산이_없는_경우_에외() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> OPERATION_MAPPER.getOperationStrategy("A")
        );
    }

}
