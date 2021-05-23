package lotto.domains;

import java.util.*;

public class LottoNumbers {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = makeLottoNumbers();
    }

    public LottoNumbers(List<Integer> lottoNumbers) {
        validateNumber(lottoNumbers);
        validateSize(lottoNumbers);
        validateDuplication(lottoNumbers);
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }
    //TODO 피드백 : 로또 후보 번호는 변하지 않는 데이터, 한번만 초기화 되도록 개선
    /*
        로또를 만들 때마다 매번 로또 후보 번호 목록을 생성하는 구조 입니다 😄
        로또 후보 번호 (1~45)는 변하지 않는 데이터 입니다 😄
        이 부분도 한번만 초기화 될 수 있도록 개선되면 좋겠습니다 🙇
     */
    private List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumberList;
        List<Integer> numberList = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        lottoNumberList = numberList.subList(0,6);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    private void validateNumber(List<Integer> lottoNumbers) {
        for (int lottoNumber : lottoNumbers) {
            validateMaxMinNumber(lottoNumber);
        }
    }

    private void validateMaxMinNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또번호는 1부터 45까지의 값을 입력해주세요");
        }
    }

    private void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> set = new HashSet<>(lottoNumbers);
        if (set.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException("로또번호는 중복될수 없습니다.");
        }
    }

    private void validateSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또번호는 여섯자리를 입력해주세요");
        }
    }

    public boolean contains(int number) {
        return lottoNumbers.contains(number);
    }

    public List<Integer> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
