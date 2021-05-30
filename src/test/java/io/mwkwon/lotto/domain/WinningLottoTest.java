package io.mwkwon.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    void create() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.create(1),
                LottoNumber.create(2),
                LottoNumber.create(3),
                LottoNumber.create(4),
                LottoNumber.create(5),
                LottoNumber.create(6)
        );
        Lotto lotto = Lotto.create(lottoNumbers);
        LottoNumber bonusLottoNumber = LottoNumber.create(7);

        WinningLotto winningLotto = WinningLotto.create(lotto, bonusLottoNumber);
        assertThat(winningLotto).isEqualTo(WinningLotto.create(lotto, bonusLottoNumber));
    }
}
