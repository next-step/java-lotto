package study.lotto.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.lotto.dispenser.Lottos;
import study.lotto.lottery.Lottery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    private static final LottoNumber bonusLottoNumber = new LottoNumber(7);
    private List<LottoNumber> lottoNumbers;

    @BeforeEach
    public void init() {
        this.lottoNumbers = Arrays.asList(new LottoNumber(1)
                , new LottoNumber(2)
                , new LottoNumber(3)
                , new LottoNumber(4)
                , new LottoNumber(5)
                , new LottoNumber(6));
    }

    @Test
    void test_of_first() {
        // Given
        Lotto lotto = new Lotto(lottoNumbers);
        WinLottoNumbers winLottoNumbers = new WinLottoNumbers(lottoNumbers, bonusLottoNumber);
        WinningLotto lottery = lotto.lottery(winLottoNumbers);

        // When
        LottoRank lottoRank = LottoRank.of(lottery);

        // Then
        assertEquals(lottoRank, LottoRank.FIRST);
    }

    @Test
    void test_of_none() {
        // Given
        WinningLotto winningLotto = new WinningLotto(new ArrayList<>());

        // When
        LottoRank lottoRank = LottoRank.of(winningLotto);

        // Then
        assertEquals(lottoRank, LottoRank.NONE);
    }

}