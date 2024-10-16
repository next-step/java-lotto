package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private List<LottoNumber> numbers;
    public LottoNumbers(String[] lottoNumbers) {
        this(initLottoNumbers(Arrays.stream(lottoNumbers).mapToInt(Integer::parseInt).toArray()));
    }

    public LottoNumbers(int[] lottoNumbers) {
        this(initLottoNumbers(lottoNumbers));
    }
    public LottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private static List<LottoNumber> initLottoNumbers(int[] lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException("로또");
        }
        List<LottoNumber> numbers = new ArrayList<>();
        for (Integer lottoNum : lottoNumbers) {
            numbers.add(new LottoNumber(lottoNum));
        }
        return numbers;
    }

    public LottoRankingEnum getRanking(Lotto winningLotto) {
        return  LottoRankingEnum.getEnumByMatchCount((int)winningLotto.getLottoNumbers().numbers.stream().filter(x-> contains(x)).count());
    }

    public boolean contains(LottoNumber lottoNumber) {
        int matchCount = (int)numbers.stream().map(LottoNumber::getValue).filter(num -> num == lottoNumber.getValue()).count();
        return matchCount > 0;
    }

    private static void validate(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개 로또번호로 구성되어야 합니다.");
        }

        int distinctCnt = (int) numbers.stream().map(LottoNumber ::getValue).distinct().count();

        if (distinctCnt != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복을 허용하지 않습니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
