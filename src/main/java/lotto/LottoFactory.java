package lotto;
import java.security.InvalidParameterException;
import java.util.*;

public class LottoFactory {

    public static final int LOTTO_SIZE = 6;

    public static List<LottoNumber> createRandom(){
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        while (lottoNumbers.size() != LOTTO_SIZE) {
            LottoNumber lottoNumber = new LottoNumber();
            if (!lottoNumbers.contains(lottoNumber)) {
                lottoNumbers.add(lottoNumber);
            }
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
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
