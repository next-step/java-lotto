package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.util.LottoStringtoNumbers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

        Lotto lotto = new Lotto(testNumbers);

        assertThat(lotto.checkWinningCount(LottoStringtoNumbers.convertStringtoNumbers(input))).isEqualTo(result);
    }
}