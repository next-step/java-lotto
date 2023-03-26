package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private static final int DEFAULT_DIGIT = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    public List<Integer> lottoNumbers = new ArrayList<>();

    public LottoTicket(List<Integer> lottoNumbers) {
        checkLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getNumbers(){
        return this.lottoNumbers;
    }

    //로또번호 생성체크 로직
    public static void checkLotto(List<Integer> targetNumber) {
        isValidNumber(targetNumber);
        isValidSize(targetNumber);
        isDupNumber(targetNumber);
    }

    //1~45 사이 수인지 체크
    public static void isValidNumber(List<Integer> targetNumber){
        boolean isValid = targetNumber.stream().allMatch(i -> i >= MINIMUM_NUMBER && i <= MAXIMUM_NUMBER);
        if(isValid == false) {
            throw new IllegalArgumentException("1~45 사이의 번호가 아닙니다.");
        }
    }

    //6자리 숫자인지 체크
    public static void isValidSize(List<Integer> targetNumber){
        if(targetNumber.size() != DEFAULT_DIGIT) {
            throw new IllegalArgumentException("로또 번호가 6자리가 아닙니다.");
        }
    }

    //중복된 번호인지 체크
    public static void isDupNumber(List<Integer> targetNumber){
        int distinctCnt = (int) targetNumber.stream()
                .distinct()
                .count();

        if(distinctCnt != targetNumber.size()) {
            throw new IllegalArgumentException("중복된 번호를 사용할 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format(lottoNumbers.toString()));
        return output.toString();
    }
}