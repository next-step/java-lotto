package lotto.util;

import lotto.domain.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerate {

    private static int LOTTO_LIST_FROM_INDEX = 0;

    public static List<LottoNumber> initAutoLottoNumbers() {
        List<LottoNumber> numbers =  IntStream.rangeClosed(LottoConstants.getLottoMinNumber(), LottoConstants.getLottoMaxNumber())
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return sortLottoNumber(numbers.subList(LOTTO_LIST_FROM_INDEX, LottoConstants.getLottoMaxSize()));
    }

    public static List<LottoNumber> initLottoNumbers(String lottoNumber) {
        List<LottoNumber> numberList = Arrays.stream(lottoNumber.split(", "))
                .mapToInt(LottoGenerate::convertNumber)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        if(!isLottoResultNumberSize(numberList)){
            throw new IllegalArgumentException("로또 번호는 숫자 6개만 입력됩니다. 입력값 : " + numberList);
        }

        return sortLottoNumber(numberList);
    }

    private static List<LottoNumber> sortLottoNumber(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().sorted(Comparator.comparing(LottoNumber::getNumber)).collect(Collectors.toList());
    }

    private static int convertNumber(String number) {
        return Integer.parseInt(number);
    }

    private static boolean isLottoResultNumberSize(List<LottoNumber> numberList) {
        return numberList.size() == LottoConstants.getLottoMaxSize();
    }
}
