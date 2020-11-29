package lotto.automatic.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    private LottoGenerator generator;

    @BeforeEach
    void setUp() {
        this.generator = new LottoGenerator(new ShuffleStrategy() {
            @Override
            public void shuffle(List<LottoNumber> nums) {
                // none
            }
        });
    }

    @Test
    @DisplayName("구입금액 전달시 일치하는 숫자의 로또 구매 확인")
    public void 금액_입력시_정확한_로또_수량_확인() {

        List<Lotto> lottoList = generator.generateLotto(3);

        for (Lotto lott : lottoList) {
            System.out.println(lott.toString());
        }

        assertThat(lottoList.size()).isEqualTo(3);
    }


}