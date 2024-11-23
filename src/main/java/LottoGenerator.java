import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final RandomGenerator randomGenerator;

    public LottoGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Lotto generate(){
        return generate(this.randomGenerator.generate(6));
    }

    public List<Lotto> generate(int lottoCount){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++){
            lottos.add(this.generate());
        }

        return lottos;
    }

    public List<Lotto> generate(Money money){
        return generate(money.availLottoCount());
    }

    public Lotto generate(ArrayList<Integer> nums) {
        return new Lotto(nums);
    }
}
