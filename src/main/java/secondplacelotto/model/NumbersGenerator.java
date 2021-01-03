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
    
    public static List<Integer> generateLottoNumbers(){
        Collections.shuffle(number);

        List<Integer> lottoNumbers = new ArrayList<Integer>(){
            {
                for (int i = 0; i < 6; i++) {
                    add(number.get(i));
                }
            }
        };

        Collections.sort(lottoNumbers);
        
        return lottoNumbers;
    }
}
