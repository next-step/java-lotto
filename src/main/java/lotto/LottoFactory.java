package lotto;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int LOTTO_SIZE = 6;

    public static List<LottoNumber> createRandom(){
        List<LottoNumber> lottoNumbersList = IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(lottoNumbersList);
        List<LottoNumber> result = lottoNumbersList.subList(0, LOTTO_SIZE);
        Collections.sort(result);
        return result;
    }

    public static List<LottoNumber> createManual(String numbers) {
        String[] splits = split(numbers);
        List<LottoNumber> result = new ArrayList<>();
        for (String s : splits) {
            result.add(new LottoNumber(Integer.parseInt(s)));
        }
        Collections.sort(result);
        return result;
    }

    public static String[] split(String numbers){
        String[] result = numbers.replaceAll(" ","").split(",");
        if(result.length != LOTTO_SIZE){
            throw new InvalidParameterException("로또 번호는 6개만 가능합니다");
        }
        return result;
    }
}
