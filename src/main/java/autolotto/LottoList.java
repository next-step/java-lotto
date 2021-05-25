package autolotto;

public class LottoList {
    private Lotto[] lottoList;
    private WinStatistics winStatistics;

    public LottoList(int num) {
        lottoList = new Lotto[num];
        for (int i = 0; i < num; i++) {
            lottoList[i] = new Lotto();
        }
    }

    public Lotto[] lottoList() {
        return lottoList;
    }

    public void calculateWinList(int[] winList) {
        winStatistics = new WinStatistics();
        for (int i = 0; i < lottoList.length; i++) {
            winStatistics.collectWin(lottoList[i].countWin(winList));
        }
    }

    public String outPutWinList() {
        return this.winStatistics.generateWinWords();
    }
}
