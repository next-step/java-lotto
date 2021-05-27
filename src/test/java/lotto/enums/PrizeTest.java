package lotto.enums;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.error.ErrorMessage;
import lotto.lotto.LottoResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class PrizeTest {
    @Test
    @DisplayName("일치하는 로또 개수 반환")
    void getPrize() {
        //given
        //when
        Prize prize = Prize.valueOf(3, false);
        //then
        assertThat(prize.money()).isEqualTo(Prize.FIFTH.money());
    }

    @Test
    @DisplayName("2등 결과 확인")
    void getSecondPrize() {
        //given
        //when
        Prize prize = Prize.valueOf(5, true);
        //then
        assertThat(prize.money()).isEqualTo(Prize.SECOND.money());
    }

    @Test
    @DisplayName("3등 결과 확인")
    void getThirdPrize() {
        //given
        //when
        Prize prize = Prize.valueOf(5, false);
        //then
        assertThat(prize.money()).isEqualTo(Prize.THIRD.money());
    }

    @ParameterizedTest
    @DisplayName("valueOf 메서드 결과 테스트 - 실패")
    @ValueSource(ints = {0, -1, 7, 9, 90})
    void valueOfFailed(int countOfMatch) {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Prize.valueOf(countOfMatch, false))
                .withMessageContaining(ErrorMessage.INVALID_LOTTO_PRIZE_ENUM);
    }

    @Test
    @DisplayName("valueOf 메서드 결과 테스트 - 성공")
    void valueOfSuccess() {
        //given
        //when
        //then
        assertThat(Prize.valueOf(6, false).money()).isEqualTo(Prize.FIRST.money());
    }

    @Test
    @DisplayName("당첨 카운트 테스트")
    void increase() {
        //given
        LottoResult lottoResult = new LottoResult();
        //when
        lottoResult.increaseCount(Prize.THIRD.matchingCount, false);
        lottoResult.increaseCount(Prize.FOURTH.matchingCount, false);
        lottoResult.increaseCount(Prize.FOURTH.matchingCount, false);
        //then
        assertThat(lottoResult.count(Prize.THIRD)).isEqualTo(1);
        assertThat(lottoResult.count(Prize.FOURTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 금액 테스트")
    void income() {
        //given
        LottoResult lottoResult = new LottoResult();
        //when
        lottoResult.increaseCount(Prize.THIRD.matchingCount, false);
        lottoResult.increaseCount(Prize.SECOND.matchingCount, true);
        //then
        assertThat(lottoResult.income()).isEqualTo(Prize.SECOND.money() + Prize.THIRD.money());
    }
}