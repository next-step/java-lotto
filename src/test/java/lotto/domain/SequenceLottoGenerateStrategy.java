package lotto.domain;

public class SequenceLottoGenerateStrategy extends LottoGenerateStrategy {

    private int sequenceStartIndex = 0;

    public SequenceLottoGenerateStrategy() {
        this(Ball.MIN_NUMBER, Ball.MAX_NUMBER);
    }

    public SequenceLottoGenerateStrategy(int minNumber, int maxNumber) {
        super(minNumber, maxNumber);
    }

    @Override
    public Lotto generate() {
        if (sequenceStartIndex + Lotto.SIZE > Ball.MAX_NUMBER) {
            sequenceStartIndex = 0;
        }
        Lotto lotto = new Lotto(
                this.balls.subList(sequenceStartIndex, sequenceStartIndex + Lotto.SIZE)
        );
        sequenceStartIndex += Lotto.SIZE;
        return lotto;
    }
}
