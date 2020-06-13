package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public static final int LOTTO_RANGE_START_NUMBER = 1;
    public static final int LOTTO_RANGE_LAST_NUMBER = 45;
    public static final int LOTTO_CREATE_COUNT = 6;
    public static final String LOTTO_AUTO_NUMBER_DELIMETER = ",";
    private static List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_RANGE_START_NUMBER, LOTTO_RANGE_LAST_NUMBER)
                                                    .boxed()
                                                    .collect(Collectors.toList());

    public static List<Integer> makeAutoNumber(){
        List<Integer> lottoNumber = new ArrayList<>();
        Collections.shuffle(lottoNumbers);
        for (int i = 0; i < LOTTO_CREATE_COUNT; i++) {
            lottoNumber.add(lottoNumbers.get(i));
        }
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    public static List<Integer> makeManualNumber(String manualNumber){
        return validate(Arrays.stream(manualNumber.split(LOTTO_AUTO_NUMBER_DELIMETER))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
    }

    private static List<Integer> validate(List<Integer> numbers) {
        int numberSize = (int) numbers.stream().distinct().count();
        if (LottoNumberGenerator.LOTTO_CREATE_COUNT != numberSize
                || LottoNumberGenerator.LOTTO_CREATE_COUNT != numbers.size()) {
            throw new IllegalArgumentException("로또 번호 입력 에러발");
        }
        if (LottoNumberGenerator.LOTTO_RANGE_LAST_NUMBER < Collections.max(numbers)) {
            throw new IllegalArgumentException("45초과 번호 입력!!");
        }
        if (LottoNumberGenerator.LOTTO_RANGE_START_NUMBER > Collections.min(numbers)) {
            throw new IllegalArgumentException("1미만 번호 입력!!");
        }
        return numbers;
    }
}
