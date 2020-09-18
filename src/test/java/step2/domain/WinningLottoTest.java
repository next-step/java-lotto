package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    WinningLotto winningLotto;
    Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void init() {
        winningLotto = WinningLotto.create("1, 2, 3, 4, 5, 6", "45");
        lottoNumbers = Stream.of("1, 2, 3, 4, 45, 6".split(","))
                .map(value -> Integer.parseInt(value.trim()))
                .map(value -> LottoNumber.of(value))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호가 중복일 경우 체크")
    void bonusNumberCheck() {
        assertThrows(IllegalArgumentException.class, () -> WinningLotto.create("1, 2, 3, 4, 45, 6", "45"));
    }

    @Test
    @DisplayName("로또 번호 비교하기")
    void matchNumber() {
        assertEquals(winningLotto.matchNumber(lottoNumbers), 5);
    }

    @Test
    @DisplayName("로또 보너스 넘버 비교하기")
    void matchBonusNumber() {
        assertTrue(winningLotto.matchBonusNumber(lottoNumbers));
    }
}