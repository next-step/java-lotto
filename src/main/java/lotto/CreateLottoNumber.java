package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateLottoNumber {
    private final static int MAX_NUMBER = 45;
    private final static int MIN_NUMBER = 1;
    private final static int COUNT = 6;
    private List<LottoNumber> numbers;
    public CreateLottoNumber() {
        numbers = createNumbers();
    }
    public List<LottoNumber> createLottoNumbers() {
        Collections.shuffle(this.numbers);

        return selectLottoNumbers();
    }

    private List<LottoNumber> selectLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int i = 1; i <= COUNT; i++){
            lottoNumbers.add(numbers.get(i));
        }
        return lottoNumbers;
    }

    private List<LottoNumber> createNumbers() {
        List<LottoNumber> nums = new ArrayList<>();
        for(int i = MIN_NUMBER; i <= MAX_NUMBER; i++){
            nums.add(new LottoNumber(i));
        }
        return nums;
    }
}
