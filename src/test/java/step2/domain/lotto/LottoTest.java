package step2.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.ListNullPointerException;
import step2.exception.MissMatchSizeException;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    @DisplayName("Lotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        Lotto lotto = Lotto.of(lottoNumbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 인스턴스를 문자열로 생성 가능한지 테스트")
    @Test
    void 생성_문자열() {
        // given
        String sentence = "1, 2, 3, 4, 5, 6";

        // when
        Lotto lotto = Lotto.of(sentence);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 인스턴스 null 주입시 예외처리 테스트")
    @Test
    void 검증_Null() {

        // given
        Set<LottoNumber> nullLottoNumbers = null;

        // when and then
        assertThatThrownBy(() -> {
            Lotto.of(nullLottoNumbers);
        }).isInstanceOf(ListNullPointerException.class)
                .hasMessageContaining("null인 리스트가 입력되었습니다.");

    }

    @DisplayName("Lotto 인스턴스에 갯수가 맞지 않는 값 주입시 예외처리 테스트")
    @Test
    void 검증_6개_미만_및_초과() {

        // given
        lottoNumbers.add(LottoNumber.valueOf(7));

        // when and then
        assertThatThrownBy(() -> {
            Lotto.of(lottoNumbers);
        }).isInstanceOf(MissMatchSizeException.class)
                .hasMessageContaining("갯수가 맞지 않습니다.");

    }

    @DisplayName("Lotto 인스턴스가 소유한 값 반환 여부 테스트")
    @Test
    void 반환() {

        // given
        Lotto lotto = Lotto.of(lottoNumbers);

        // when
        Set<LottoNumber> actual = lotto.getLottoNumbers();

        // then
        assertThat(actual).isEqualTo(lottoNumbers);
    }

    @DisplayName("Lotto 인스턴스가 소유값을 기준으로 동등 판단 여부 테스트")
    @Test
    void 비교() {

        // when
        Lotto firstLotto = Lotto.of(lottoNumbers);
        Lotto secondLotto = Lotto.of(lottoNumbers);

        // then
        assertThat(firstLotto).isEqualTo(secondLotto);
    }

    @DisplayName("Lotto 인스턴스가 소유값을 기준으로 몇개가 일치하는지 판단 테스트")
    @Test
    void 포함_갯수() {
        // given
        Lotto firstLotto = Lotto.of(lottoNumbers);
        Lotto secondLotto = Lotto.of(lottoNumbers);

        // when
        int actual = firstLotto.getCorrectCount(secondLotto);

        // then
        assertThat(actual).isEqualTo(6);
    }

}