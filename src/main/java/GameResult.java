public class GameResult {
    private final Candidates candidates;
    private final double ratio;
    private final long result_3;
    private final long result_4;
    private final long result_5;
    private final long result_6;

    public GameResult(Candidates candidates,
                      double ratio,
                      long result_3,
                      long result_4,
                      long result_5,
                      long result_6) {
        this.candidates = candidates;
        this.ratio = ratio;
        this.result_3 = result_3;
        this.result_4 = result_4;
        this.result_5 = result_5;
        this.result_6 = result_6;
    }

    public Candidates getCandidates() { return candidates; }
    public double getRatio() { return ratio; }
    public long getResult_3() { return result_3; }
    public long getResult_4() { return result_4; }
    public long getResult_5() { return result_5; }
    public long getResult_6() { return result_6; }
}
