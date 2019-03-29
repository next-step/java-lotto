package domain;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class LottoTest {
    private Lotto lotto;

    @Before
    public void setUp() {
        // 1,2,3,4,5,6 setting
        List<Integer> nums = new ArrayList<>();
        for (int i=1 ; i<=6; i++) {
            nums.add(i);
        }
        LottoNumbers numbers = LottoNumbers.createInstance(nums);
        lotto = new Lotto(numbers);
    }

}
