import java.util.ArrayList;
import java.util.Random;

public class LottoGenerator {

    public Lotto generate(){
        ArrayList<Integer> nums = new ArrayList<>();

        Random rand = new Random();

        for(int i = 0; i < 6; i++){
            nums.add(rand.nextInt(45) + 1);
        }

        return generate(nums);
    }

    public Lotto generate(ArrayList<Integer> nums) {
        return new Lotto(nums);
    }

    public ArrayList<Lotto> generate(int money){
        if (money < 1000) {
            return new ArrayList<>();
        }

        int lottoCnt = money / 1000;

        ArrayList<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < lottoCnt; i++){
            lottos.add(this.generate());
        }

        return lottos;
    }
}
