package lotto;

import java.util.List;

public class LottoInputView {
    public static boolean validateLottoNumbers(List<Integer> numbers){
        if(numbers.size() != 6) {
            throw new IllegalArgumentException("번호 갯수가 6개가 아닙니다.");
        }
        return true;
    }
}
