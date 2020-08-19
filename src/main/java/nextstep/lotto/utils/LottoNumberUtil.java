package nextstep.lotto.utils;

import nextstep.lotto.dto.LottoNumber;

import java.util.*;

public class LottoNumberUtil {

    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoNumberUtil() {}

    public static List<LottoNumber> generator() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(int number : getSixNumbers()){
            lottoNumbers.add(LottoNumber.create(number));
        }

        return lottoNumbers;
    }

    public static List<LottoNumber> transStringNumberToLottoNumber(List<String> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for(String number : numbers){
            lottoNumbers.add(LottoNumber.createByString(number.trim()));
        }

        return lottoNumbers;
    }

    private static List<Integer> getSixNumbers() {
        List<Integer> lottoEntryNumbers = allLottoNumbers();
        Collections.shuffle(lottoEntryNumbers);

        return lottoEntryNumbers.subList(0,LOTTO_NUMBER_COUNT);
    }

    private static List<Integer> allLottoNumbers(){
        List<Integer> lottoNumbers = new ArrayList<>();
        for(int i = LOTTO_MINIMUM_BOUND; i <= LOTTO_MAXIMUM_BOUND; i++){
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }
}

