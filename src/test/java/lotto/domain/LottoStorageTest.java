package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStorageTest {

    @Test
    @DisplayName("LottoStorage 생성 테스트")
    void create() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(LottoNumber.from(1));
        lottoNumbers.add(LottoNumber.from(2));
        lottoNumbers.add(LottoNumber.from(3));
        lottoNumbers.add(LottoNumber.from(4));
        lottoNumbers.add(LottoNumber.from(5));
        lottoNumbers.add(LottoNumber.from(6));

        List<Lotto> lottoList = List.of(Lotto.from(lottoNumbers));

        LottoStorage lottoStorage = new LottoStorage(lottoList);

        assertThat(lottoList).isEqualTo(lottoStorage.copy());
    }
}