package lotto;

public class ManualNumberGenerator implements NumberGenerator{
    private final Lottos lottos;

    public ManualNumberGenerator(Lottos lottos) {
        this.lottos = lottos;
    }

    @Override
    public Lottos generate(int count) {
        return lottos;
    }
}
