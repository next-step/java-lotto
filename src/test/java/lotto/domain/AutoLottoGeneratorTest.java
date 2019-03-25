package lotto.domain;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {
    @Test
    public void 모든_로또_숫자_생성() {
        // given
        AutoLottoGenerator lottoGenerator = new AutoLottoGenerator();
        List<LottoNumber> allLottoNumbers =
                IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                        .mapToObj(LottoNumber::getInstance)
                        .collect(Collectors.toList());

        // when
        // then
        assertThat(lottoGenerator.getAllLottoNumbers())
                .containsExactlyElementsOf(allLottoNumbers);
    }

    @Test
    public void 로또_번호_정상_생성() {
        // 비정상 경우는 Lotto, LottoNumber 테스트에서 걸림
        LottoGenerator lottoGenerator = new AutoLottoGenerator();
        lottoGenerator.generate();
    }
}
