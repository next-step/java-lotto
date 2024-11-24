public class LottoGame {
    private final LottoGenerator lottoGenerator;

    public LottoGame() {
        this.lottoGenerator = new LottoGenerator(new RandomGenerator());
    }

    public Candidates setup(Money money) {
        Candidates candidates = new Candidates();

        for (int i = 0; i < money.availLottoCount(); i++){
            candidates.add(new Candidate(lottoGenerator.generate()));
        }

        return candidates;
    }

    public CandidateRanks play(Lotto winning, Candidates candidates) {
        return candidates.calcRanks(winning);
    }
}
