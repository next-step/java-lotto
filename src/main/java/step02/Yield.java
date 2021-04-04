package step02;

public class Yield {
    private static int yield = 0;
    private static int math3Benefit = 5000;
    private static int math4Benefit = 50000;
    private static int math5Benefit = 1500000;
    private static int math6Benefit = 2000000000;

    private Yield() {
    }

    public static void setYield(int money, LottoResultDTO resultDTO) {
        yield += resultDTO.getMath3() * math3Benefit;
        yield += resultDTO.getMath4() * math4Benefit;
        yield += resultDTO.getMath5() * math5Benefit;
        yield += resultDTO.getMath6() * math6Benefit;

        resultDTO.setYield(Math.round((yield / (double) money) * 100) / 100.0);
    }
}
