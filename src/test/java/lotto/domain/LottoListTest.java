package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoListTest {

    LottoList lottoList = new LottoList();

    @DisplayName("보너스 당첨 여부 테스트")
    @Test
    void getBuyCount() {

        assertAll("operator",
                () -> assertTrue(lottoList.isBonus(new Lotto("1,2,3,4,5,6"),new LottoNumber(6))),
                () -> assertFalse(lottoList.isBonus(new Lotto("1,2,3,4,5,6"),new LottoNumber(7)))
        );
    }

    @DisplayName("당첨 개수 테스트")
    @Test
    void getNumberOfWinnings() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        assertAll("operator",
                () -> assertEquals(lottoList.getNumberOfWinnings(lotto,new Lotto("1,2,3,4,5,6")),6),
                () -> assertEquals(lottoList.getNumberOfWinnings(lotto,new Lotto("1,2,3,4,5,7")),5),
                () -> assertEquals(lottoList.getNumberOfWinnings(lotto,new Lotto("1,2,3,4,7,8")),4),
                () -> assertEquals(lottoList.getNumberOfWinnings(lotto,new Lotto("1,2,3,7,8,9")),3),
                () -> assertEquals(lottoList.getNumberOfWinnings(lotto,new Lotto("1,2,7,8,9,10")),2),
                () -> assertEquals(lottoList.getNumberOfWinnings(lotto,new Lotto("7,8,9,10,44,45")),0)
        );
    }

}
