package lotto.utils;

import lotto.domain.LottoNo;
import org.junit.Test;

import java.util.List;

import static lotto.utils.LottoNumberGenerator.generate;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoCollectionUtilsTest {

    @Test
    public void 문자배열을_로또숫자리스트로_변환할수있다() {
        String[] texts = new String[] { "1", "2", "3", "4", "5", "6" };
        List<LottoNo> result = LottoCollectionUtils.convert(texts);
        assertThat(result).isEqualTo(generate(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 숫자리스트와_숫자를_병합할수있다() {
        List<LottoNo> numbers = generate(1, 2, 3, 4, 5);
        List<LottoNo> result = LottoCollectionUtils.merge(numbers, LottoNo.create(6));
        assertThat(result).isEqualTo(generate(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 숫자리스트와_여러숫자를_병합할수있다() {
        List<LottoNo> numbers = generate(1, 2, 3, 4, 5);
        List<LottoNo> result = LottoCollectionUtils.merge(numbers, LottoNo.create(6), LottoNo.create(7));
        assertThat(result).isEqualTo(generate(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    public void Null은_제외된다() {
        List<LottoNo> numbers = generate(1, 2, 3, 4, 5);
        assertThat(LottoCollectionUtils.merge(numbers, null)).isEqualTo(numbers);

        assertThat(LottoCollectionUtils.merge(null, LottoNo.create(1))).isEqualTo(generate(1));
    }
}