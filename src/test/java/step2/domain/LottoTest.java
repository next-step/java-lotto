package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6).mapToObj(number -> new LottoNumber(number)).collect(Collectors.toList());

    @Test
    public void 로또번호를_문자열로_표현할_수_있다() {
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
