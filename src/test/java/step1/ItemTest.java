package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ItemTest {

    @DisplayName("Item에 숫자를 제외하고 다른 문자열이 들어오면 IllegalArgument Exception")
    @ParameterizedTest
    @ValueSource(strings = {":", "kk", "1:", "-2", "43242k"})
    void itemCreateNotNumberTest(String itemStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> Item.from(itemStr));
    }

    @DisplayName("Item에 숫자를 빈 값이 들어오면 IllegalArgument Exception")
    @ParameterizedTest
    @NullAndEmptySource
    void itemCreateNullOrEmptyTest(String itemStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> Item.from(itemStr));
    }

    @DisplayName("add 메서드는 더해서 Item을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "4:5:9"}, delimiter = ':')
    void addTest(String leftStr, String rightStr, String expectStr) {
        Item left = Item.from(leftStr);
        Item right = Item.from(rightStr);

        Item actual = left.add(right);

        assertThat(actual).isEqualTo(Item.from(expectStr));
    }
}