package random;

import java.util.List;
import java.util.Random;

public class RandomLottoNumbers implements LottoGenerator {
    @Override
    public List<Integer> executeStrategy() {
        Random random = new Random();
        return List.of(1,2,3,4,5,6);//TODO 임시로 지정.
    }
}
