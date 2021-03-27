package domain;

import enums.Rank;
import exception.DuplicateNumberException;
import exception.ExceedNumberException;
import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> numbers = new ArrayList<>();
    private static final int SIZE_LIMIT = 6;

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoNumbers(List<LottoNumber> numbers){
        validate(numbers);
        this.numbers = numbers;
    }

    public Rank convertRank(List<LottoNumber> winnerNumber) {
        long match = numbers.stream()
            .filter(winnerNumber::contains)
            .count();
        return Rank.find(match);
    }

    public boolean isRank(List<LottoNumber> winnerNumber) {
        long match = numbers.stream()
            .filter(winnerNumber::contains)
            .count();
        return match > 3;
    }


    private void validate(List<LottoNumber> numbers) {
        checkExceedNumber(numbers);
        checkDuplicateNumber(numbers);
    }

    private void checkExceedNumber(List<LottoNumber> numbers) {
        if(numbers.size() != SIZE_LIMIT){
            throw new ExceedNumberException("6개의 번호를 입력해주세요");
        }
    }

    private void checkDuplicateNumber(List<LottoNumber> numbers) {
        if(numbers.stream().distinct().count() != SIZE_LIMIT){
            throw new DuplicateNumberException("중복되는 번호가 있습니다.");
        }
    }
}
