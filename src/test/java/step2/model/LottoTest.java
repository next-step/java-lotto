package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @ParameterizedTest
    @CsvSource(value={"1,2,10,20,30,40:2", "1,2,3,4,5,6:6", "1,20,2,40,3,44:3"}, delimiter = ':')
    @DisplayName("구입한 로또 대비 당첨된 개수")
    void checkWinningCount(String input, int result) {
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(3);
        testNumbers.add(4);
        testNumbers.add(5);
        testNumbers.add(6);

        assertThat(Lotto.newListLotto(testNumbers).checkWinningCount(Lotto.newStringLotto(input))).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource( strings = { "-1,2,3,4,5,6", "0,1,2,3,4,5", "1,2,3,4,5,46" } )
    @DisplayName("구입한 로또 대비 당첨된 개수")
    void checkNumber(String lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.newStringLotto(lottoNumbers));
    }

    @ParameterizedTest
    @ValueSource( strings = { "1,2,3,4,5", "1,2,3,4,5,6,7" })
    @DisplayName("구입한 로또 대비 당첨된 개수")
    void checkSize(String lottoNumbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.newStringLotto(lottoNumbers));
    }
}