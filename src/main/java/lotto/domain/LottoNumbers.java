package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> numbers;
    public LottoNumbers(String[] lottoNumbers) {
        this(initLottoNumbers(lottoNumbers));
    }
    public LottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private static List<LottoNumber> initLottoNumbers(String[] lottoNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (String lottoNum : lottoNumbers) {
            numbers.add(new LottoNumber(Integer.valueOf(lottoNum)));
        }
        return numbers;
    }
    public int getMatchCount(LottoNumbers winningNumbers) {
        return  (int)winningNumbers.numbers.stream().filter(x-> contains(x)).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        int matchCount = (int)numbers.stream().map(LottoNumber::getValue).filter(num -> num == lottoNumber.getValue()).count();
        return matchCount > 0;
    }

    private static void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new RuntimeException("로또는 6개 로또번호로 구성되어야 합니다.");
        }

        int distinctCnt = (int) numbers.stream().distinct().count();

        if (distinctCnt != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복을 허용하지 않습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
