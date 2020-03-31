package lotto.domain.stragegy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberAutoGeneratorTest {

    @DisplayName("1~45 사이의 랜덤 로또 번호를 생성 한다.")
    @Test
    public void generateLottoNumber_success() throws Exception {
        //when
        List<Integer> integers = LottoNumberAutoGenerator.generateLottoNumber();

        //then
        assertThat(integers.size()).isEqualTo(6);
    }

    @DisplayName("랜덤번호 2개를 생성후 비교하여 서로 달라야 한다.")
    @Test
    public void generateLottoNumber_fail_compareResult() throws Exception {
        //when
        List<Integer> compare1 = LottoNumberAutoGenerator.generateLottoNumber();
        List<Integer> compare2 = LottoNumberAutoGenerator.generateLottoNumber();

        //then
        assertThat(compare1.equals(compare2)).isFalse();
    }
}
