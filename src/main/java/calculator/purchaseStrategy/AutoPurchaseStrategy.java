package calculator.purchaseStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoPurchaseStrategy implements PurchaseStrategy{

    private static final int LIMIT_SIZE = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final List<Integer> lottoNumber = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE).boxed().collect(Collectors.toList());

    public List<Integer> generateLottoNumber(){
        Collections.shuffle(lottoNumber);
        List<Integer> pickedNumber = new ArrayList<>();

        for(int i = 0; i < LIMIT_SIZE; i++) {
            pickedNumber.add(lottoNumber.get(i));
        }

        Collections.sort(pickedNumber);

        return pickedNumber;
    }

}
