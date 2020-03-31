package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPublisherTest {

    @DisplayName("복권을 자동 발행할 수 있다.")
    @Test
    void publishAuto() {
        LottoPublisher lottoPublisher = new LottoAutoPublisher(2);

        Lotteries actual = lottoPublisher.publish();

        assertThat(actual).isNotNull();
        assertThat(actual.count()).isEqualTo(2);
    }

    @DisplayName("복권을 수동 발행할 수 있다.")
    @Test
    void publishManual() {
        List<LottoNumbers> lottoNumbers = createLottoNumbers();
        LottoPublisher lottoPublisher = new LottoManualPublisher(lottoNumbers);

        Lotteries actual = lottoPublisher.publish();

        assertThat(actual).isNotNull();
        assertThat(actual.count()).isEqualTo(2);
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

        lottoNumbers.add(new LottoNumbers(
                        Arrays.asList(
                                LottoNumber.valueOf(7)
                                , LottoNumber.valueOf(8)
                                , LottoNumber.valueOf(9)
                                , LottoNumber.valueOf(10)
                                , LottoNumber.valueOf(11)
                                , LottoNumber.valueOf(12)
                        )
                )
        );
        return lottoNumbers;
    }
}