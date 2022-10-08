package step02.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class LottoMakerTest {

    @Test
    void 자동로또_발급_테스트_개수_확인() {
        then(LottoMaker.makeAutoLotto(3).size()).isEqualTo(3);
    }

    @Test
    void 수동로또_발급_테스트() {
        then(
            LottoMaker.makeManualLotto(List.of("1,2,3,4,5,6"))
        ).isEqualTo(
            new LottoList(List.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6))))
        );
    }
}