package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {

    @Test
    @DisplayName("Lotto 생성 테스트")
    void LottoGenerateTest() {

        Lotto lotto = new Lotto(List.of(LottoNumbers.of("1,2,3,4,5,6")));

        assertAll(
                () -> assertThat(lotto).isNotNull(),
                () -> assertThat(lotto.getLottoNumbersSize()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Lotto 번호 매칭 테스트 - lottNumbers")
    void lottoNumbersMatchingTest() {

        Lotto lotto = new Lotto(List.of(LottoNumbers.of("1,2,3,4,5,6")));
        LottoNumbers lottoNumbers = LottoNumbers.of("1, 7, 8, 9, 10, 11");

        assertThat(lotto.countMatchingBall(lottoNumbers).get(0)).isEqualTo(1);
    }


    @Test
    @DisplayName("Lotto 번호 매칭 테스트 - lottNumber")
    void lottoNumberMatchingTest() {

        Lotto lotto = new Lotto(List.of(LottoNumbers.of("1,2,3,4,5,6")));
        LottoNumber lottoNumber = LottoNumber.provideLottoNumber(1);
        assertThat(lotto.bonusNumberMatchingList(lottoNumber).get(0)).isTrue();
    }

}