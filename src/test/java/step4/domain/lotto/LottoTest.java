package step4.domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.InputInvalidStringLottoException;
import step4.exception.LottoSizeMissMatchException;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Set<LottoNumber> lottoNumbers;

    @BeforeEach
    void beforeEach() {
        lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));

    }

    @DisplayName("Lotto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        Lotto lotto = Lotto.of(lottoNumbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 인스턴스 문자열로 생성 여부 테스트")
    @Test
    void 생성_문자열() {
        // given
        String stringLottoNumbers = "1, 2, 3, 4, 5, 6";

        // when
        Lotto lotto = Lotto.of(stringLottoNumbers);

        // then
        assertThat(lotto).isNotNull();
    }

    @DisplayName("Lotto 인스턴스에 알맞지 않은 갯수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_사이즈() {
        // given
        Set<LottoNumber> invalidLottoNumbers = IntStream.range(1, 6)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));

        // when and then
        assertThatThrownBy(() -> Lotto.of(invalidLottoNumbers))
                .isInstanceOf(LottoSizeMissMatchException.class)
                .hasMessageContaining("로또 숫자가 맞지 않습니다.");

    }

    @DisplayName("Lotto 인스턴스가 잘못된 문자열을 받았을시에 예외처리 반환 여부 테스트")
    @Test
    void 검증_잘못된_문자열() {
        // given
        String stringLottoNumbers = "1,2,3,4,5,6";

        // when
        assertThatThrownBy(() -> Lotto.of(stringLottoNumbers))
                .isInstanceOf(InputInvalidStringLottoException.class)
                .hasMessageContaining("잘못된 형식의 문자열이 입력되었습니다.");

    }

    @DisplayName("Lotto 인스턴스가 소유한 값이 특정값을 가졌는지에 대한 테스트")
    @Test
    void 비교_포함한_값() {
        // given
        LottoNumber lottoNumber = LottoNumber.valueOf(1);

        // when
        Lotto lotto = Lotto.of(lottoNumbers);
        boolean actual = lotto.isIncludeLottoNumber(lottoNumber);

        // then
        assertThat(actual).isTrue();
    }

    @DisplayName("Lotto 인스턴스가 소유한 값이 몇개의 특정값을 가졌는지에 대한 테스트")
    @Test
    void 비교_포함한_값의_갯수() {
        // given
        Set<LottoNumber> anotherLottoNumbers = IntStream.range(6, 12)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));

        // when
        Lotto lotto = Lotto.of(lottoNumbers);
        Lotto anotherLotto = Lotto.of(anotherLottoNumbers);
        long actual = lotto.getCountMatch(anotherLotto);

        // then
        assertThat(actual).isEqualTo(1);
    }

    @DisplayName("Lotto 인스턴스가 소유한 값 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        Set<LottoNumber> expected = lottoNumbers;

        // when
        Lotto lotto = Lotto.of(expected);
        Set<LottoNumber> actual = lotto.getLotto();

        // then
        assertThat(actual).isEqualTo(expected);
    }

}