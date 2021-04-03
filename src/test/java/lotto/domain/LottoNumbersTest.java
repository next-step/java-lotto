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
        LottoNumbers newLottoNumbers = LottoNumbers.from(integers);
        assertThat(newLottoNumbers).isEqualTo(new LottoNumbers(newLottoNumbers.lottoNumbers()));
    }

    @Test
    @DisplayName("로또 번호가 보너스 볼을 포함하는 지 여부")
    public void contains() throws Exception {
        LottoNumbers lottoNumbers = LottoNumbers.from(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers.contains(new BonusBall(1))).isTrue();
        assertThat(lottoNumbers.contains(new BonusBall(7))).isFalse();
    }
}
