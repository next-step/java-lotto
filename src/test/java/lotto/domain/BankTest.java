package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BankTest {
    private Lotto answerLotto;

    @BeforeEach
    void setUp() {
        answerLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));
    }

    @DisplayName("모든 숫자가 일치하는 1등 당첨되어 상금이 2000000000 인지")
    @Test
    void first_lotto() {
        //given
        Lotto toCompareLotto = new Lotto(answerLotto);
        int expectedMatchCount = 6;
        int expectedReward = 2000000000;

        //when
        Bank bank = new Bank(answerLotto);
        LottoResult result = bank.matchLotto(toCompareLotto);

        //then
        assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
        assertThat(result.getReward()).isEqualTo(expectedReward);
    }

    @DisplayName("5개의 숫자가 일치하는 2등 당첨되어 상금이 1500000 인지")
    @Test
    void second_lotto() {
        //given
        Lotto toCompareLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(45)
        ));
        int expectedMatchCount = 5;
        int expectedReward = 1500000;

        //when
        Bank bank = new Bank(answerLotto);
        LottoResult result = bank.matchLotto(toCompareLotto);

        //then
        assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
        assertThat(result.getReward()).isEqualTo(expectedReward);
    }

    @DisplayName("4개의 숫자가 일치하는 3등 당첨되어 상금이 50000 인지")
    @Test
    void third_lotto() {
        //given
        Lotto toCompareLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(44), new LottoNumber(45)
        ));
        int expectedMatchCount = 4;
        int expectedReward = 50000;


        //when
        Bank bank = new Bank(answerLotto);
        LottoResult result = bank.matchLotto(toCompareLotto);

        //then
        assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
        assertThat(result.getReward()).isEqualTo(expectedReward);
    }

    @DisplayName("3개의 숫자가 일치하는 4등 당첨되어 상금이 5000 인지")
    @Test
    void fourth_lotto() {
        //given
        Lotto toCompareLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)
        ));
        int expectedMatchCount = 3;
        int expectedReward = 5000;


        //when
        Bank bank = new Bank(answerLotto);
        LottoResult result = bank.matchLotto(toCompareLotto);

        //then
        assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
        assertThat(result.getReward()).isEqualTo(expectedReward);
    }

    @DisplayName("3개 미만의 숫자가 일치하여 상금이 0 인지")
    @Test
    void none_lotto() {
        //given
        Lotto toCompareLotto = new Lotto(Arrays.asList(
                new LottoNumber(40), new LottoNumber(41), new LottoNumber(42),
                new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)
        ));
        int expectedMatchCount = 0;
        int expectedReward = 0;


        //when
        Bank bank = new Bank(answerLotto);
        LottoResult result = bank.matchLotto(toCompareLotto);

        //then
        assertThat(result.getMatchCount()).isEqualTo(expectedMatchCount);
        assertThat(result.getReward()).isEqualTo(expectedReward);
    }
}
