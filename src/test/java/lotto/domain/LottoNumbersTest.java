package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 객체 생성")
    public void create() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(lottoNumbers.lottoNumbers()));
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumbers newLottoNumbers = LottoNumbers.createByintegers(integers);
        assertThat(newLottoNumbers).isEqualTo(new LottoNumbers(newLottoNumbers.lottoNumbers()));
    }
}
