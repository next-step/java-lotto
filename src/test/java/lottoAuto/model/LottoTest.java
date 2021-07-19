package lottoAuto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {
    private WinningLotto winningLottoTest;

    @BeforeEach
    public void set() {
        Set<LottoNumber> winningNumbers = new HashSet<>();
        winningNumbers.add(new LottoNumber(1));
        winningNumbers.add(new LottoNumber(2));
        winningNumbers.add(new LottoNumber(3));
        winningNumbers.add(new LottoNumber(4));
        winningNumbers.add(new LottoNumber(5));
        winningNumbers.add(new LottoNumber(6));
        Lotto winningLotto = new Lotto(winningNumbers);
        winningLottoTest = new WinningLotto(winningLotto, new LottoNumber(7));
    }

    @DisplayName("로또 번호는 6개이하면 예외를 발생시킨다.")
    @Test
    public void lottoSizeTest() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));

        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("로또 번호는 6개이상이면 예외를 발생시킨다.")
    @Test
    public void lottoSizeOverTest() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        lottoNumbers.add(new LottoNumber(7));

        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }

    @DisplayName("Lotto객체는 LottoResult객체를 반환할 수 있다.")
    @Test
    public void makeLottoResult() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));
        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.makeLottoResult(winningLottoTest)).isInstanceOf(LottoResult.class);
    }
}
