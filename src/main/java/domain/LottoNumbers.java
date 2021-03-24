package domain;

import exception.ExceedNumberException;
import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> numbers = new ArrayList<>();

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumbers(List<LottoNumber> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if(numbers.size() != 6){
            throw new ExceedNumberException("6개의 번호를 입력해주세요");
        }
    }
}
