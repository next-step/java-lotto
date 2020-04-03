package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @DisplayName("무작위 6개의 로또 번호를 생성한다.")
    @Test
    void generateAuto() {
        Lotteries lotteries = LottoNumberGenerator.generateAutomatically(1);

        assertThat(lotteries).isNotNull();
        assertThat(lotteries.count()).isOne();
    }

    @DisplayName("수동 입력한 6개의 로또 번호를 생성한다.")
    @Test
    void generateManual() {
        Lotteries lotteries = LottoNumberGenerator.generateManually(createLottoNumbers());

        assertThat(lotteries).isNotNull();
        assertThat(lotteries.count()).isOne();
    }

    private List<LottoNumbers> createLottoNumbers() {
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
        return lottoNumbers;
    }
}