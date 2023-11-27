package step4.domain.lotto;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoGeneratorTest {

    @Test
    void 수동_로또_생성_테스트() {
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator(List.of(
                Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(45))
        ));

        List<UserLotto> generate = manualLottoGenerator.generate();

        System.out.println("generate.toString() = " + generate.toString());

        assertThat(manualLottoGenerator.generate().size()).isEqualTo(1);
    }

}
