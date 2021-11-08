package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @DisplayName("Item에 숫자를 제외하고 다른 문자열이 들어오면 IllegalArgument Exception")
    @ParameterizedTest
    @ValueSource(strings = {":","kk","1:",":2","43242k"})
    void itemCreateNotNumberTest(String itemStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> Item.from(itemStr));
    }

    @DisplayName("Item에 숫자를 빈 값이 들어오면 IllegalArgument Exception")
    @ParameterizedTest
    @NullAndEmptySource
    void itemCreateNullOrEmptyTest(String itemStr) {
        assertThatIllegalArgumentException().isThrownBy(() -> Item.from(itemStr));
    }
}