package lotto.model;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FixLottoGeneratorTest {

    private List<LottoNumber> createLotto(int... ints) {
        return Arrays.stream(ints)
            .boxed()
            .map(LottoNumber::new)
            .collect(toList());
    }

    @Test
    @DisplayName("로또 수동 생성기는 사용자가 원하는 로또를 생성한다.")
    void 로또_수동_생성기_사용자_원하는_로또() {
        // given
        List<LottoNumber> lottoNumbers = createLotto(1, 2, 3, 4, 5, 6);
        // when
        FixLottoGenerator fixLottoGenerator = new FixLottoGenerator(lottoNumbers);
        // then
        assertThat(fixLottoGenerator.generate())
            .extracting("number")
            .contains(1, 2, 3, 4, 5, 6);
    }


}
