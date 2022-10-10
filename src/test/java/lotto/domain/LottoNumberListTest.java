package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberListTest {

    @Test
    void create() {
        LottoNumberList lottoNumberList = new LottoNumberList(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        );

        assertThat(lottoNumberList).isEqualTo(new LottoNumberList(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )
        ));
    }

    @Test
    void valid_size() {
        List<LottoNumber> lottoSizeUnder = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );
        List<LottoNumber> lottoSizeOver = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7)
        );

        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoNumberList(lottoSizeUnder)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumberList(lottoSizeOver)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
