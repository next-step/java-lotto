package study.lotto.util;

import study.lotto.LottoGame;
import study.lotto.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private static final String NUMBER_DELIMITER = ", |,";

    public static List<LottoNumber> randomNumbers(){
        List<Integer> allNumbers = LottoGame.AVAILABLE_LOTTONUMBERS;
        Collections.shuffle(allNumbers);
        return allNumbers.stream().limit(LottoGame.MARK_SIZE).map(LottoNumber::new).sorted().collect(Collectors.toList());
    }
    
    public static List<LottoNumber> markedNumbers(List<Integer> numbers){
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
        validateSize(lottoNumbers);
        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }

    public static List<LottoNumber> markedNumbers(String stringNumbers){
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(stringNumbers);
        validateSize(lottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }


    private static List<LottoNumber> convertToLottoNumbers(String stringNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String stringNumber : stringNumbers.split(NUMBER_DELIMITER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(stringNumber)));
        }
        return lottoNumbers;
    }

    //1메소드가 하나의 책임을 갖도록 하기위해 사이즈 체크를 메소드 분리하였는데 static 메소드에서 분리를 하였기 때문에 static 메소드가 되었습니다.
    //이런 경우 이처럼 그냥 static method로 하는지, 아니면 제너레이터 메서드를 non static 메서드로 해야하는지 의견을 듣고 싶습니다.
    private static void validateSize(List<LottoNumber> markedLottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(markedLottoNumbers);
        if (lottoNumberSet.size() != LottoGame.MARK_SIZE) {
            throw new IllegalArgumentException("6개의 로또 번호가 아닙니다.");
        }
    }

}
