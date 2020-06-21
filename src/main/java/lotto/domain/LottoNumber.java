package lotto.domain;


import lotto.utils.LottoType;

import java.util.List;
import java.util.stream.Collectors;


public class LottoNumber {

    private static int LOTTO_MAX_NUMBER = 45;
    private static int LOTTO_MIN_NUMBER = 1;
    private static int NEED_LOTTO_COUNT = 6;

    private int number;

    public LottoNumber(String text){
        this(Integer.parseInt(text));
    }

    public LottoNumber(int number){
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("LOTTO번호가 범위를 초과합니다.");
        }
        this.number = number;
    }


//    public String getSelectedLottoNumbers() {
//        String joinNumbers = selectedLottoNumber.stream()
//                .map(number -> String.valueOf(number))
//                .collect(Collectors.joining(COMMA_SPACE));
//        return "[" + joinNumbers + "]";
//    }
//
//    public int getEqualsCount(List<Integer> lastWeekNumbers) {
//
//        for (Integer number : lastWeekNumbers) {
//            containCheck(number);
//        }
//        return this.equalCount;
//    }
//
//    private void containCheck(Integer number) {
//
//        if (selectedLottoNumber.contains(number)) {
//            this.equalCount += 1;
//        }
//    }
}
