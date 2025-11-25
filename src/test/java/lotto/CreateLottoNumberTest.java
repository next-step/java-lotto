package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateLottoNumberTest {

    @Test
    void create() {
        CreateLottoNumber createLottoNumber = new CreateLottoNumber();

        List<LottoNumber> lottoNumbers = createLottoNumber.createLottoNumbers();

        assertThat(lottoNumbers).hasSize(6);
    }
}
