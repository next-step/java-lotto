package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @DisplayName("중복되는 로또넘버 숫자를 넣어본다.")
    @Test
    void name() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoNumbers = new LottoNumbers(
                    new HashSet<>(Stream.of(new LottoNo(1),
                                            new LottoNo(1),
                                            new LottoNo(2),
                                            new LottoNo(3),
                                            new LottoNo(4),
                                            new LottoNo(5))
                                        .collect(Collectors.toSet())));
        });
    }

    @DisplayName("넣은 로또넘버가 같은객체 인지 확인해본다.")
    @Test
    void createLottoNumber() {
        lottoNumbers = new LottoNumbers(new HashSet<>(Stream.of(new LottoNo(1),
                                                                       new LottoNo(2),
                                                                       new LottoNo(3),
                                                                       new LottoNo(4),
                                                                       new LottoNo(5),
                                                                       new LottoNo(6))
                                                                   .collect(Collectors.toSet())));
        assertThat(lottoNumbers).isEqualTo(
                new LottoNumbers(new HashSet<>(Stream.of(new LottoNo(1),
                                                                new LottoNo(2),
                                                                new LottoNo(3),
                                                                new LottoNo(4),
                                                                new LottoNo(5),
                                                                new LottoNo(6))
                                                            .collect(Collectors.toSet()))));
    }
}
