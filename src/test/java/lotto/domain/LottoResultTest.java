package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult(List.of(Rank.NO_MATCH, Rank.FOURTH, Rank.NO_MATCH, Rank.FIRST, Rank.NO_MATCH));
    }

    @Test
    @DisplayName("당첨 리스트가 주어졌을때 로또 결과 객체 생성")
    void lottoResult() {
        Assertions.assertThat(lottoResult.getResult()).hasSize(3);
    }

    @Test
    @DisplayName("Money 객체를 전달받아서 수익률 반환")
    void calculateRateOfReturn() {
        Assertions.assertThat(lottoResult.calculateRateOfReturn(new Money(5000))).isEqualTo(400010.0f);
    }

}
