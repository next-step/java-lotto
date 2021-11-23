package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    @DisplayName("LottoNumbers 생성자 테스트")
    public void constructor() {
        assertThat(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())))
                .isEqualTo(new LottoNumbers(IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList())));
    }

    @Test
    @DisplayName("자동으로 로또번호를 생성한다.")
    public void createAutoLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.createAutoLottoNumbers();
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
@DisplayName("생성된 로또번호가 1~45 사이인지 테스트한다.")
    public void validateLottoNumbers() {
        List<Integer> defaultNumbers = IntStream.rangeClosed(1, 45)
                .boxed().collect(Collectors.toList());

        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.createAutoLottoNumbers();

        assertThat(defaultNumbers).containsAll(lottoNumbers.getLottoNumbers());
    }

}
