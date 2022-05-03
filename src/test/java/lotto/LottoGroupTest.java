package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class LottoGroupTest {
    @Test
    void LottoGroup_로또그룹_생성한다() {
        LottoGroup lottoGroup = new LottoGroup(List.of(
                new Lotto(new int[]{1, 2, 3, 4, 5, 6}),
                new Lotto(new int[]{7, 8, 9, 10, 11, 12}))
        );
        assertThat(lottoGroup).isEqualTo(new LottoGroup(
                List.of(
                        new Lotto(List.of(
                                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                        )),
                        new Lotto(List.of(
                                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12)
                        ))
                )
        )).isEqualTo(lottoGroup);
    }

    @Test
    void LottoGroup_로또그룹_생성한다_전략패턴이용() {
        LottoGroup lottoGroup = new LottoGroup(List.of(
                new Lotto(new int[]{1, 2, 3, 4, 5, 6}),
                new Lotto(new int[]{1, 2, 3, 4, 5, 6}))
        );
        assertThat(lottoGroup).isEqualTo(new LottoGroup(2, () -> List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6))));
    }


    @Test
    void getLottoGroupResult_로또그룹_결과를_반환한다() {
        LottoGroup lottoGroup = new LottoGroup(List.of(
                new Lotto(new int[]{1, 2, 3, 4, 5, 6}),
                new Lotto(new int[]{6, 8, 9, 10, 11, 12}),
                new Lotto(new int[]{4, 5, 6, 16, 17, 18}),
                new Lotto(new int[]{19, 20, 21, 22, 23, 24}),
                new Lotto(new int[]{25, 26, 27, 28, 29, 30}),
                new Lotto(new int[]{31, 32, 33, 34, 35, 36}),
                new Lotto(new int[]{37, 38, 39, 40, 41, 42}))
        );
        assertThat(lottoGroup.getLottoGroupResult(new Lotto(new int[]{4, 5, 6, 8, 9, 10}))).isEqualTo(new LottoGroupResult(Map.of(
                Rank.MISS, 4,
                Rank.FOURTH, 2,
                Rank.THIRD, 1
        )));

    }
}