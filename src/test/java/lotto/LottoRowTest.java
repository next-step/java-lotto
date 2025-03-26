package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRowTest {

    @Test
    @DisplayName("로또 번호 한줄 생성")
    void 로또_번호_한줄_생성() {
        List<Integer> numbers = new ArrayList<>(List.of(30,31,1,5,9,6));
        LottoRow expectedLottoRow = new LottoRow(List.of(1, 5, 6, 9, 30, 31));

        LottoRow lottoRow = new LottoRow(numbers);

        assertThat(lottoRow).isEqualTo(expectedLottoRow);
    }
}