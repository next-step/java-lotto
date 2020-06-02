package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private static final int LOTTO_COUNT = 3;

    @Test
    void drawingLotto() {
        Lotto lotto = new Lotto(LOTTO_COUNT);

        lotto.drawingLotto();
        List<LottoNumber> numberList = lotto.getLottoNumbers();

        long count = numberList.stream().filter(lottoNumber -> lottoNumber.getNumbers().size() == 6).count();
        assertThat(count).isEqualTo(3);
    }
}
