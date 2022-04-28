package lottoauto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AutoLotto {
    private static final int LENGTH = 6;
    private static final Integer[] SAMPLE_NUMBERS = {1,2,3,4,5,6};
    private final Integer[] numbers;

    public AutoLotto() {
        Integer[] autoLottoNumbers = SAMPLE_NUMBERS;
        Collections.shuffle(Arrays.asList(autoLottoNumbers));
        this.numbers = autoLottoNumbers;
    }

    public int size() {
        return LENGTH;
    }

    public Integer[] getNumbers() {
        return numbers;
    }
}
