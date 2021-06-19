package lottoAuto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoTest {

    @DisplayName("로또 번호는 6개이하면 예외를 발생시킨다.")
    @Test
    public void lottoSizeTest() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));

        assertThrows(IllegalArgumentException.class, () -> new Lotto(lottoNumbers));
    }
}
