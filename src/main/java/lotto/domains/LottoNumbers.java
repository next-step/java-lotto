package lotto.domains;

import java.util.*;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = makeLottoNumbers();
    }
    public LottoNumbers(List<Integer> lottoNumbers) {
        validateNumber(lottoNumbers);
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }
    private List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumberList;
        List<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        lottoNumberList = numberList.subList(0,6);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    private void validateNumber(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            if (lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException("로또번호는 1부터 45까지의 값을 입력해주세요");
            }
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> set = new HashSet<>(lottoNumbers);
        if (set.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호는 중복될수 없습니다.");
        }
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또번호는 여섯자리를 입력해주세요");
        }
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }
}
