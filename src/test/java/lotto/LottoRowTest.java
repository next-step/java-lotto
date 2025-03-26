package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRowTest {

    @Test
    @DisplayName("로또 번호 한줄 생성")
    void 로또_번호_한줄_생성() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 5, 6, 9, 30, 31));
        LottoRow expectedLottoRow = new LottoRow(List.of(1, 5, 6, 9, 30, 31));

        LottoRow lottoRow = new LottoRow(numbers);

        assertThat(lottoRow).isEqualTo(expectedLottoRow);
    }

    @Test
    @DisplayName("로또 번호 개수 체크")
    void 로또_번호_개수_체크() {
        List<Integer> numbers = new ArrayList<>(List.of(30,31,1,5));

        assertThatThrownBy(() -> new LottoRow(numbers))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 한줄의 번호 개수는 6개여야합니다");
    }
}