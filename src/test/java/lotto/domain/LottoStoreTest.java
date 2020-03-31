package lotto.domain;

import lotto.exception.ManualSizeOverflowException;
import lotto.exception.NoPurchasePriceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoStoreTest {

    private LottoPublisher lottoPublisher;
    @BeforeEach
    void setUp() {
        lottoPublisher = new LottoPublisher();
    }

    @DisplayName("구입 금액에 해당하는 복권을 구매한다.")
    @Test
    void buy() {
        final Price price = new Price(2000);
        final int expect = 2;

        Lotteries actual = LottoStore.sell(price, lottoPublisher);

        assertThat(actual.count()).isEqualTo(expect);
    }

    @DisplayName("수동 구입시 금액보다 많이 입력했을 경우 커스텀 예외를 발생한다.")
    @Test
    void throwOverSizeException() {
        final Price price = new Price(1000);
        final List<LottoNumbers> manualLottoNumbers = createLottoNumbers();

        assertThatExceptionOfType(ManualSizeOverflowException.class).isThrownBy(
                () -> LottoStore.sellManual(price, manualLottoNumbers)
        );
    }

    @DisplayName("구입 금액이 로또 금액보다 작을 경우 NoPurchasePriceException 을 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    void noPurchaseException(int price) {
        assertThatExceptionOfType(NoPurchasePriceException.class).isThrownBy(
                () -> LottoStore.sell(new Price(price), lottoPublisher)
        );
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