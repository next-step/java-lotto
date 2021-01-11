package secondplacelotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumbersGenerator {

    private final static List<Integer> number = new ArrayList<Integer>(){
        {
            for (int i = 1; i <= 45; i++) {
                add(i);
            }
        }
    };
    
    public static List<LottoNumber> generateLottoNumbers(){
        Collections.shuffle(number);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        List<Integer> shuffleNumbers = new ArrayList<Integer>(){
            {
                for (int i = 0; i < 6; i++) {
                    add(number.get(i));
                }
            }
        };

        Collections.sort(shuffleNumbers);

        for (int lottoNumber : shuffleNumbers) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }
        
        return lottoNumbers;
    }
}
