public class LottoGame {
    private final LottoGenerator lottoGenerator;
    private final Candidates candidates;

    public LottoGame() {
        this.lottoGenerator = new LottoGenerator(new RandomGenerator());
        this.candidates = new Candidates();
    }

    public GameResult play(Money money, Lotto winning) {
        for (int i = 0; i < money.availLottoCount(); i++){
            candidates.add(new Candidate(lottoGenerator.generate()));
        }

        return new GameResult(
                candidates,
                candidates.calculateRatio(winning),
                candidates.countMatch(winning, new MatchCount(3)),
                candidates.countMatch(winning, new MatchCount(4)),
                candidates.countMatch(winning, new MatchCount(5)),
                candidates.countMatch(winning, new MatchCount(6))
        );
    }
}
