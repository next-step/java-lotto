package lotto.domain;

import lotto.utils.LottoInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    private LottoInput lottoInput;

    @BeforeEach
    void setUp() {
        lottoInput = new LottoInput(Arrays.asList(10, 20, 30, 40, 45));
    }

}
