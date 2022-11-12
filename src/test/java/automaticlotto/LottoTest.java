package automaticlotto;

import automaticlotto.automaticexception.InputValueException;
import automaticlotto.domain.Lotto;
import automaticlotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @DisplayName("로또 숫자 갯수 확인")
    @Test
    void lottoNumberCountTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        lottoNumbers.add(new LottoNumber(7));

        assertThatExceptionOfType(InputValueException.class).isThrownBy(() -> new Lotto(lottoNumbers));
    }

    @DisplayName("로또 중복 숫자 확인")
    @Test
    void overlapLottoTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        assertThatExceptionOfType(InputValueException.class).isThrownBy(() -> new Lotto(lottoNumbers));
    }

}
