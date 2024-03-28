package lotto;

import lotto.model.Lotto;
import lotto.model.LottoSale;
import lotto.model.LottoWinCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoWinTest {
    @Test
    @DisplayName("6개의 로또 번호 일치 테스트")
    void sixLottoNumber_sameWinNumber() {

        int result = LottoWinCheck.compareWinNumbers(new ArrayList<>(Arrays.asList(23,8,11,20,3,45)),
                                                new Lotto("23,8,11,20,3,45"));

        assertThat(result).isEqualTo(6);
    }
}
