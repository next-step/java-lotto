package lotto.View;


public class OutputView {
    private final String INFORMATION_BUY_COUNT = "개를 구매했습니다.";

    private OutputView() {
    }

    public static OutputView init() {
        return new OutputView();
    }

    public void userInstructionCount(int count) {
        System.out.println(count + INFORMATION_BUY_COUNT);
    }

    public void boughtLottoList(Lottos lottos) {
        lottos.toList().stream().forEach(lotto -> {
            System.out.println(lotto.toString());
        });
    }

    public void LottoResult(Lottos lottos, List<Integer> lastweekWinLotto) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Map<Integer, Integer> winList = lottos.match(lastweekWinLotto);

        winList = winList.entrySet().stream()
                .filter(key -> key.getKey() >= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        winList.forEach((key, value) -> {
            winLottoGradeAndPrizePrint(key, value);
        });

        Double revenueRate = lottos.revenueRate(winList);

        System.out.println("총 수익률은 " +trimDecimalZeroResult(revenueRate) + "입니다.");
    }

    private void winLottoGradeAndPrizePrint(Integer key, Integer value) {
        String prize = trimDecimalZeroResult(LottoGrade.findGrade(key).getPrize());
        System.out.println(key + "개 일치 (" + prize + "원) - " + value + "개");
    }

    private String trimDecimalZeroResult(double result) {
        if ((int) result == result) {
            return String.valueOf((int) result);
        }
        return String.valueOf(result);
    }
}