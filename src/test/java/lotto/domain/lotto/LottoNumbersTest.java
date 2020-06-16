package lotto.domain.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {
    List<LottoNumber> lottoNumber = IntStream.rangeClosed(1, 6)
            .mapToObj(x -> LottoNumber.create(x)).collect(Collectors.toList());

    @Test
    void 생성_테스트() {
        assertThatCode(() -> LottoNumbers.createAuto()).doesNotThrowAnyException();
        assertThatCode(() -> LottoNumbers.createManual("1, 2, 3, 4, 5, 6")).doesNotThrowAnyException();
        assertThatCode(() -> LottoNumbers.create(lottoNumber)).doesNotThrowAnyException();
    }

    @Test
    void 당첨번호와_로또번호의_일치수를_반환한다() {
        LottoNumbers lottoNumbers = LottoNumbers.create(lottoNumber);
        List<LottoNumber> winningLottoNumber = Arrays.asList(3, 4, 5, 11, 22, 33).stream()
                .map(k -> LottoNumber.create(k)).collect(Collectors.toList());
        LottoNumbers winningNumbers = LottoNumbers.create(winningLottoNumber);

        int matchCount = lottoNumbers.findMatchCount(winningNumbers);

        assertThat(matchCount).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "6, true", "34, false"})
    void 보너스볼_존재_확인(int bonus, boolean expected) {
        LottoNumbers lottoNumbers = LottoNumbers.create(lottoNumber);
        LottoNumber bonusBall = LottoNumber.create(bonus);

        boolean result = lottoNumbers.haveBonusBall(bonusBall);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 여섯자리_로또번호를_생성한다() {
        LottoNumbers lottoNumbers = LottoNumbers.createAuto();
        assertThat(lottoNumbers.getLottoNumbers()).size().isEqualTo(6);
    }

    @Test
    void 로또번호_입력수_확인() {
        List<LottoNumber> lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6, 7).stream()
                .map(k -> LottoNumber.create(k)).collect(Collectors.toList());

        assertThatThrownBy(() -> LottoNumbers.create(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_중복입력_확인() {
        List<LottoNumber> lottoNumber = Arrays.asList(1, 2, 3, 4, 6, 6).stream()
                .map(k -> LottoNumber.create(k)).collect(Collectors.toList());

        assertThatThrownBy(() -> LottoNumbers.create(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("중복된 로또 번호가 존재 합니다");
    }
}
