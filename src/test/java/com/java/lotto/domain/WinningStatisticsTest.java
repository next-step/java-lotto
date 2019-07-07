package com.java.lotto.domain;

import com.java.lotto.exception.OutOfLottoNumberRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class WinningStatisticsTest {
    LottoPurchase lottoPurchase;
    Lotto lotto;
    String winningNumber;
    WinningStatistics winningStatistics;

    @BeforeEach
    void setup() {
        List<String> manualNumbers = new ArrayList<>();
        manualNumbers.add("1,2,3,4,5,6");
        manualNumbers.add("7,8,9,11,12,45");
        this.lottoPurchase = new LottoPurchase(3000, manualNumbers);

        lotto = new Lotto(lottoPurchase);
    }

    @Test
    @DisplayName("당첨 번호 입력 값 숫자 유효성 검증")
    void numberValidation() {
        winningNumber = "1,2,3,4,5,a";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
        {
            LottoNumbersGenerator.manualNumbersGenerator(winningNumber);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 값 숫자 범위(1~45) 유효성 검증")
    void numberRangeValidation() {
        winningNumber = "1,2,3,4,5,50";
        assertThatExceptionOfType(OutOfLottoNumberRangeException.class).isThrownBy(() ->
        {
            LottoNumbersGenerator.manualNumbersGenerator(winningNumber);
        });
    }

    @Test
    @DisplayName("로또 3개 맞춤 검증")
    void isWinningNumberCountThree() {
        winningNumber = "1, 2, 3, 7, 8, 9";

        winningStatistics = new WinningStatistics(new WinningTicket(winningNumber, 45), lotto);
        assertThat(winningStatistics.countByReward(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 4개 맞춤 검증")
    void isWinningNumberCountFour() {
        winningNumber = "1, 2, 3, 4, 8, 9";
        winningStatistics = new WinningStatistics(new WinningTicket(winningNumber, 45), lotto);
        assertThat(winningStatistics.countByReward(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 5개 맞춤 검증")
    void isWinningNumberCountFive() {
        winningNumber = "1, 2, 3, 4, 5, 8";
        winningStatistics = new WinningStatistics(new WinningTicket(winningNumber, 45), lotto);
        assertThat(winningStatistics.countByReward(5)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 6개 맞춤 검증")
    void isWinningNumberCountSix() {
        winningNumber = "1, 2, 3, 4, 5, 6";
        winningStatistics = new WinningStatistics(new WinningTicket(winningNumber, 45), lotto);
        assertThat(winningStatistics.countByReward(6)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 5개 및 보너스 번호 맞춤 검증")
    void isWinningNumberCountBonus() {
        winningNumber = "7, 8, 9, 11, 12, 44";
        winningStatistics = new WinningStatistics(new WinningTicket(winningNumber, 45), lotto);
        assertThat(winningStatistics.countByReward(LottoReward.MATCH_FIVE_BONUS)).isEqualTo(1);
    }
}
