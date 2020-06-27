package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private Lotto lotto;
    private Lotto winningLotto;

    @BeforeEach
    void setUp(){

        List<LottoNumber> lottoNumber = new ArrayList<LottoNumber>();
        lottoNumber.add(new LottoNumber(1));
        lottoNumber.add(new LottoNumber(10));
        lottoNumber.add(new LottoNumber(20));
        lottoNumber.add(new LottoNumber(33));
        lottoNumber.add(new LottoNumber(40));
        lottoNumber.add(new LottoNumber(45));
        lotto = new Lotto(lottoNumber);

        List<LottoNumber> winningNumbers = new ArrayList<LottoNumber>();
        winningNumbers.add(new LottoNumber(1));
        winningNumbers.add(new LottoNumber(10));
        winningNumbers.add(new LottoNumber(20));
        winningNumbers.add(new LottoNumber(33));
        winningNumbers.add(new LottoNumber(40));
        winningNumbers.add(new LottoNumber(45));
        winningLotto = new Lotto(winningNumbers);
    }

    @DisplayName("유저 로또번호와 우승로또번호 6자리가 일치할때")
    @Test
    void matchCount() {

        int matchCount = lotto.matchCount(winningLotto);
        assertThat(matchCount).isEqualTo(5);
    }

}