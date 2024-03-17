package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("from 호출 시 LottoNumbers 반환")
    void from() {
        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)));
        lottoNumberList.add(LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)));
        lottoNumberList.add(LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)));
        LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumberList);
        assertThat(lottoNumbers.size()).isEqualTo(3);
        lottoNumberList.add(LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumbers.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("computeLottoResult로 넘어오는 LottoNumber로 LottoResult 반환")
    void computeLottoResult() {

        List<LottoNumber> lottoNumberList = new ArrayList<>();
        lottoNumberList.add(LottoNumber.from(List.of(1, 2, 3, 11, 22, 33)));
        lottoNumberList.add(LottoNumber.from(List.of(1, 2, 3, 21, 42, 45)));
        lottoNumberList.add(LottoNumber.from(List.of(1, 2, 3, 4, 44, 11)));
        lottoNumberList.add(LottoNumber.from(List.of(1, 2, 3, 4, 5, 11)));

        LottoNumber winningNumber = LottoNumber.from(List.of(1, 2, 3, 4, 5, 6));

        LottoNumbers lottoNumbers = LottoNumbers.from(lottoNumberList);

        LottoResult lottoResult = lottoNumbers.computeLottoResult(winningNumber);
        assertThat(lottoResult.winnings()).isEqualTo(1560000L);
    }
}
