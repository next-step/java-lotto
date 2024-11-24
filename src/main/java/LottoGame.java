public class LottoGame {
    private final LottoGenerator lottoGenerator;

    public LottoGame() {
        this.lottoGenerator = new LottoGenerator(new RandomGenerator());
    }

    public Candidates appendAutoCandidates(Money money, Candidates manualCandidates) {
        int autoLottoCount = money.availLottoCount() - manualCandidates.size();

        for (int i = 0; i < autoLottoCount; i++){
            manualCandidates.add(new Candidate(lottoGenerator.generate()));
        }

        return manualCandidates;
    }

    public CandidateRanks play(Lotto winning, BonusBall bonusBall, Candidates candidates) {
        return candidates.calcRanks(winning, bonusBall);
    }
}
