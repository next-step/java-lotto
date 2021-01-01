package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto lotto;

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,2", "2,3", "3,4", "4,5", "5,6"},delimiter = ',')
    @DisplayName("번호 정렬 테스트")
    void sort(int index, int number) {
        lotto = new Lotto(asList(new Number(6),new Number(4),new Number(5),new Number(3),new Number(1),new Number(2)));
        assertThat(lotto.getNumbers().get(index).getNumber()).isEqualTo(number);
    }
}