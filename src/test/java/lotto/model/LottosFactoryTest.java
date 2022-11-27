package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottosFactoryTest {

    @Test
    @DisplayName("입력한 수동로또번호로 로또를 생성한다")
    void lottoList() {
        List<String> buyLotto = List.of("3", "5", "10", "12", "16", "33");

        Set<LottoNumber> set = Set.of(
                LottoNumber.lottoNumber(3), LottoNumber.lottoNumber(5),
                LottoNumber.lottoNumber(10), LottoNumber.lottoNumber(12),
                LottoNumber.lottoNumber(16), LottoNumber.lottoNumber(33)
        );

        assertThat(new LottoFactory(buyLotto).stringToLotto()).isEqualTo(new Lotto(set));
    }
}