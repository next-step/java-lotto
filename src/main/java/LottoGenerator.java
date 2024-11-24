import java.util.ArrayList;

public class LottoGenerator {

    private final RandomGenerator randomGenerator;

    public LottoGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public Lotto generate(){
        return generate(this.randomGenerator.generate(6));
    }

    private Lotto generate(ArrayList<Integer> nums) {
        return new Lotto(nums);
    }
}
