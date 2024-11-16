import java.util.ArrayList;

public class LottoGenerator {

    private final RandomGenerator randomGenerator;

    public LottoGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Lotto generate(){
        return generate(this.randomGenerator.generate(6));
    }

    public ArrayList<Lotto> generate(int lottoCount){
        ArrayList<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < lottoCount; i++){
            lottos.add(this.generate());
        }

        return lottos;
    }

    public ArrayList<Lotto> generate(Money money){
        return generate(money.AvailLottoCount());
    }

    public Lotto generate(ArrayList<Integer> nums) {
        return new Lotto(nums);
    }
}
