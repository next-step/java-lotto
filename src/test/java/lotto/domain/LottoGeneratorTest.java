package lotto.domain;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    public void 모든_로또_숫자_생성() {
        // given
        List<Integer> allLottoNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

        // when
        // then
        assertThat(LottoGenerator.getAllLottoNumbers())
                .containsExactlyElementsOf(allLottoNumbers);
    }

    @Test
    public void 로또_번호_생성() {
        // given
        // when
        List<Integer> lottoNumbers = LottoGenerator.generate();

        // then
        assertThat(lottoNumbers).hasSize(6);
    }
}
