package lotto.domain;

import lotto.util.Split;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoGeneratorTest {

    @DisplayName("수동번호 메모대로 lotto 가 생성된다,")
    @Test
    public void generatorTest() {
        String lottoMemo1 = "1,2,3,4,5,6";
        String lottoMemo2 = "1,2,3,7,5,8";
        ManualLottoMemo memo = ManualLottoMemo.of(List.of(lottoMemo1, lottoMemo2));

        List<Lotto> lottos = ManualLottoGenerator.generate(memo);
        assertThat(lottos.size()).isEqualTo(2);
        assertThat(lottos).contains(
                Lotto.of(LottoNumberPool.get(Split.from(lottoMemo1, ","))),
                Lotto.of(LottoNumberPool.get(Split.from(lottoMemo2, ","))));
    }

    @DisplayName("수동번호를 메모를 전달하지 않을 경우 빈 List가 전달된다.")
    @Test
    public void generatorNullTest() {
        List<Lotto> lottos = ManualLottoGenerator.generate(null);

        assertThat(lottos.size()).isEqualTo(0);
        assertThat(lottos).isEmpty();
    }

    @DisplayName("수동번호가 없는 빈 메모를 전달하면 빈 List<Lotto>가 전달된다.")
    @Test
    public void generatorEmptyTest() {
        List<Lotto> lottos = ManualLottoGenerator.generate(ManualLottoMemo.empty());

        assertThat(lottos.size()).isEqualTo(0);
        assertThat(lottos).isEmpty();
    }

}