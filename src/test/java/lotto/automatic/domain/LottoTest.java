package lotto.automatic.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트 ")
    public void creation_로또_인스턴스() {

        Lotto lotto1 = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(toList()));
        Lotto lotto2 = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(toList()));

        assertThat(lotto1.equals(lotto2)).isTrue();
    }

    @Test
    @DisplayName("자동 로또 생성 테스트 ")
    public void creation_자동_로또_인스턴스() {

        Lotto lotto1 = Lotto.auto();

        int matchCount = lotto1.matchCount(
                new Lotto(IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::of)
                        .collect(toList())));

        assertThat(matchCount).isLessThanOrEqualTo(6);

    }

    @Test
    @DisplayName("로또 번호가 6개를 넘는 경우")
    public void 로또번호가_6개를_넘는_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(IntStream.rangeClosed(1, 7)
                        .mapToObj(LottoNumber::of)
                        .collect(toList()))
                );
    }

    @Test
    @DisplayName("로또 번호가 6개에 못미치는 경우")
    public void 로또번호가_5개인_경우() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(IntStream.rangeClosed(1, 5)
                        .mapToObj(LottoNumber::of)
                        .collect(toList()))
                );
    }

    @Test
    @DisplayName("가지고 있는 숫자 확인")
    public void contain_number() {
        Lotto lotto = new Lotto(
                IntStream.rangeClosed(1, 6)
                        .mapToObj(LottoNumber::of)
                        .collect(toList()));

        assertThat(lotto.contain(LottoNumber.of(6))).isTrue();
    }

    @Test
    @DisplayName("매치 카운트 테스트")
    public void matchCountTest() {

        Lotto lotto = new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(toList()));
        int matchCount = lotto.matchCount(new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::of)
                .collect(toList())));
        assertThat(matchCount).isEqualTo(6);

    }

}
