package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LotteriesTest {

    @DisplayName("로또 복권은 6개의 로또 번호를 가지도록 객체 생성을 할 수 있다.")
    @Test
    void create() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
            lottoNumbers.add(new LottoNumbers(
                    Arrays.asList(
                            LottoNumber.valueOf(1)
                            , LottoNumber.valueOf(2)
                            , LottoNumber.valueOf(3)
                            , LottoNumber.valueOf(4)
                            , LottoNumber.valueOf(5)
                            , LottoNumber.valueOf(6)
                    )
            )
        );

        Lotteries expect = new Lotteries(lottoNumbers);

        Lotteries actual = new Lotteries(lottoNumbers);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("로또 목록을 갖고올 수 있다.")
    @Test
    void getLottoNumbers() {
        Lotto lotto = new Lotto();
        Lotteries lotteries = lotto.buy(new Price(2000));

        final List<LottoNumbers> lottoNumbers = lotteries.getLottoNumbers();

        assertThat(lottoNumbers).hasSize(2);
    }
}