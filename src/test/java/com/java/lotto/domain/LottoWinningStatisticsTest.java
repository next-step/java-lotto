package com.java.lotto.domain;

import com.java.lotto.exception.OutOfLottoNumberRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoWinningStatisticsTest {
    LottoTickets lottoTickets;
    String winningNumber;
    LottoWinningStatistics lottoWinningStatistics;

    @BeforeEach
    void setup() {
        int count = 3;
        List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,2,3,4,5,6");
        manualNumbers.add("4,5,6,7,8,9");
//        manualNumbers.add("7,8,9,10,11,12");
        lottoTickets = LottoTicketsGenerator.manualTicketsGenerator(2, manualNumbers);
        lottoWinningStatistics = new LottoWinningStatistics();
    }

    @Test
    void 당첨_번호_입력값중_숫자이외의_값_검증() {
        winningNumber = "1,2,3,4,5,a";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
        {
            LottoNumbersGenerator.manualNumbersGenerator(winningNumber);
        });
    }

    @Test
    void 당첨_번호_입력값중_1에서_45_범위에_없는값_검증() {
        winningNumber = "1,2,3,4,5,50";
        assertThatExceptionOfType(OutOfLottoNumberRangeException.class).isThrownBy(() ->
        {
            LottoNumbersGenerator.manualNumbersGenerator(winningNumber);
        });
    }

    @Test
    void 숫자_3개_맞은_로또_찾기() {
        winningNumber = "1, 2, 3, 7, 8, 9";
        lottoWinningStatistics.findLottoWinning(LottoNumbersGenerator.manualNumbersGenerator(winningNumber), lottoTickets);
        assertThat(lottoWinningStatistics.getWinnerCount(3)).isEqualTo(2);
    }

    @Test
    void 숫자_4개_맞은_로또_찾기() {
        winningNumber = "1, 2, 3, 4, 8, 9";
        lottoWinningStatistics.findLottoWinning(LottoNumbersGenerator.manualNumbersGenerator(winningNumber), lottoTickets);
        assertThat(lottoWinningStatistics.getWinnerCount(4)).isEqualTo(1);
    }

    @Test
    void 숫자_5개_맞은_로또_찾기() {
        winningNumber = "1, 2, 3, 4, 5, 8";
        lottoWinningStatistics.findLottoWinning(LottoNumbersGenerator.manualNumbersGenerator(winningNumber), lottoTickets);
        assertThat(lottoWinningStatistics.getWinnerCount(5)).isEqualTo(1);
    }

    @Test
    void 숫자_6개_맞은_로또_찾기() {
        winningNumber = "1, 2, 3, 4, 5, 6";
        lottoWinningStatistics.findLottoWinning(LottoNumbersGenerator.manualNumbersGenerator(winningNumber), lottoTickets);
        assertThat(lottoWinningStatistics.getWinnerCount(6)).isEqualTo(1);
    }
}
