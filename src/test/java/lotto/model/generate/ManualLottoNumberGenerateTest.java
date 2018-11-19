package lotto.model.generate;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class ManualLottoNumberGenerateTest {

    LottoNumberGenerate lottoNumberGenerate;

    @Test
    public void 번호_가져오기() {
        lottoNumberGenerate = new ManualLottoNumberGenerate("1, 2, 3, 4, 5, 6");

        Set<Integer> numbers = lottoNumberGenerate.generate();
        Set<Integer> numbers1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(numbers).isEqualTo(numbers1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 번호_입력_없이_가져오기_시도() {
        lottoNumberGenerate = new ManualLottoNumberGenerate("");
    }
}