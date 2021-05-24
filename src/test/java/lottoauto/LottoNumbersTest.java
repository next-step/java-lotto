package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @DisplayName("자동로또번호발생 중복검사 테스트")
    @Test
    void 자동로또번호발생_중복검사() {
        List<LottoNumber> lottoNumberList = Stream.<LottoNumber>builder()
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .add(new LottoNumber(1))
                .build()
                .collect(Collectors.toList());

        assertThatThrownBy(()->new LottoNumbers(lottoNumberList)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복은 존재할 수 없습니다.");
    }
}
