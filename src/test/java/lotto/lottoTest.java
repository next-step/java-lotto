package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class lottoTest {


    @Test
    void 로또_번호_중복이_없음() {
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 6, 4, 6);
        assertThatExceptionOfType(IllegalAccessError.class)
                .isThrownBy(() -> new LottoNumbers(lottoNum));
    }

    @Test
    void 로또_번호는_1부터_45까지() {
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 6, 46, 5);
        assertThatExceptionOfType(IllegalAccessError.class)
                .isThrownBy(() -> new LottoNumbers(lottoNum));
    }

    @Test
    void 로또_번호는_6자리() {
        List<Integer> lottoNum = Arrays.asList(1, 2, 3, 6, 42, 5, 6);
        assertThatExceptionOfType(IllegalAccessError.class)
                .isThrownBy(() -> new LottoNumbers(lottoNum));
    }

    @ValueSource(ints = {4000})
    @ParameterizedTest
    void 금액에_따른_로또횟수_확인(int ints) {
        final LottoPurchases lottoPurchases = new LottoPurchases(ints);
        assertThat(lottoPurchases.getLottoMachineCount()).isEqualTo(4);
    }

    @ValueSource(ints = {900})
    @ParameterizedTest
    void 로또_금액을_확인(int ints) {
        final LottoPurchases lottoPurchases = new LottoPurchases(ints);
        assertThatExceptionOfType(IllegalAccessError.class)
                .isThrownBy(() -> lottoPurchases.getLottoMachineCount());
    }

    @ValueSource(ints = {3})
    @ParameterizedTest
    void 로또횟수에_따른_로또번호가_정상호출(int ints) {
        assertThat(new LottoMachine(ints)).toString();
    }

    @Test
    void 로또결과에_따라_정상_결과_호출확인() {
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers beforeLottoNumbers = new LottoNumbers(Arrays.asList(1, 3, 5, 7, 9, 11));
        int purchasesNumber = 1;
        int bonumNumber = 9;
        WinLottoNumber winLottoNumber = new WinLottoNumber(beforeLottoNumbers, bonumNumber);
        assertThat(new LottoResult(lottoNumbers, purchasesNumber, winLottoNumber)).toString();
    }
}
