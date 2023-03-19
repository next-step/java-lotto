package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    Purchase purchase = new Purchase();

    public List<LottoNumber> createNumber(final int ... listNumber) {
        List<LottoNumber> lottoNumberList = new ArrayList<>();

        for (int i: listNumber) {
            lottoNumberList.add(new LottoNumber(i));
        }

        return lottoNumberList;
    }

    @DisplayName("1등 테스트. 구입번호 6자리와 당첨번호 6자리가 모두 일치")
    @Test
    void first() {
        final var actual = new LottoGame().match(createNumber(1, 2, 3, 4, 5, 6),
                createNumber(1, 2, 3, 4, 5, 6),
                new LottoNumber(7));
        assertThat(actual).isEqualTo(Rank.FIRST);

    }

    @DisplayName("2등 테스트. 구입번호 5자리와 보너스 넘버가 당첨번호 6자리가 일치")
    @Test
    void second() {
        final var actual = new LottoGame().match(createNumber(1,2,3,4,5,7),
                createNumber(1,2,3,4,5,6),
                new LottoNumber(7));
        assertThat(actual).isEqualTo(Rank.SECOND);

    }

    @DisplayName("3등 테스트. 구입번호 5자리가 당첨번호와 일치")
    @Test
    void third() {
        final var actual = new LottoGame().match(createNumber(1,2,3,4,5,8),
                createNumber(1,2,3,4,5,6),
                new LottoNumber(7));
        assertThat(actual).isEqualTo(Rank.THIRD);

    }

    @DisplayName("4등 테스트. 구입번호 4자리가 당첨번호와 일치")
    @Test
    void fourth() {
        final var actual = new LottoGame().match(createNumber(1,2,3,4,7,8),
                createNumber(1,2,3,4,5,6),
                new LottoNumber(7));
        assertThat(actual).isEqualTo(Rank.FOURTH);

    }


    @DisplayName("5등 테스트. 구입번호 3자리가 당첨번호와 일치")
    @Test
    void fifth() {
        final var actual = new LottoGame().match(createNumber(1,2,3,7,8,9),
                createNumber(1,2,3,4,5,6),
                new LottoNumber(7));
        assertThat(actual).isEqualTo(Rank.FIFTH);

    }

    @DisplayName(value = "구입금액에 따른 구입 갯수를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {14000})
    void purchaseCount(final int amount) {
        assertThat(purchase.getPurchaseCount(amount)).isSameAs(14);
    }


}
