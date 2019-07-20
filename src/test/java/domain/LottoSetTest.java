package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;


public class LottoSetTest {

    private LottoSet lottoSet;

    @Before
    public void setUp() {
        lottoSet = LottoSet.newInstance(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    @Test
    public void 로또_세트는_오름차순으로_정렬된다() {
        // given
        List<LottoNumber> lottoNumbers = Arrays.asList(LottoNumber.of(20),
                LottoNumber.of(10),
                LottoNumber.of(5),
                LottoNumber.of(44),
                LottoNumber.of(23),
                LottoNumber.of(11));

        // when
        LottoSet lottoSet = LottoSet.newInstance(lottoNumbers);

        //then
        assertThat(lottoSet.getLottoNumbers().first()).isEqualTo(LottoNumber.of(5));
        assertThat(lottoSet.getLottoNumbers().last()).isEqualTo(LottoNumber.of(44));
    }

    @Test
    public void 당첨번호_매칭수_일치() {
        assertThat(lottoSet.countOfMatchNumber(LottoSet.newInstance(7, 8, 9, 10, 11, 12))).isEqualTo(0);
        assertThat(lottoSet.countOfMatchNumber(LottoSet.newInstance(2, 3, 4, 5, 6, 7))).isEqualTo(5);
        assertThat(lottoSet.countOfMatchNumber(LottoSet.newInstance(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    @Test
    public void 번호_매칭_일치() {
        assertFalse(lottoSet.isMatchNumber(LottoNumber.of(7)));
        assertThat(lottoSet.isMatchNumber(LottoNumber.of(6)));
    }

    @Test
    public void 로또_사이즈() {
        assertThat(LottoSet.newInstance(1, 2, 3, 4, 5, 6).getLottoNumbers()).hasSize(LottoSet.LOTTO_SIZE);
    }
}
