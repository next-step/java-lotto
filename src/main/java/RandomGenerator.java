import java.util.ArrayList;
import java.util.Random;

public class RandomGenerator {
    ArrayList<Integer> generate(int cnt) {
        ArrayList<Integer> randNums = new ArrayList<>();

        Random rand = new Random();
        for(int i = 0; i < cnt; i++){
            randNums.add(rand.nextInt(LottoNumber.MAX_LOTTO_NUMBER) + 1);
        }

        return randNums;
    }
}
