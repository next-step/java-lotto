import java.util.Map;

public class ResultView {

    private ResultView() {
    }

    public static void print(Lottos lottos) {
        System.out.printf("%d개를 구입하였습니다.\n", lottos.getLottoCount());
        System.out.println(lottos);
    }

    public static void printRanks(Ranks ranks) {
        System.out.println("당첨 통계\n---------");
        StringBuilder sb = new StringBuilder();
        sb.append("3개 일치 (5000원)-").append(ranks.count(Rank.FOURTH)).append("개").append("\n");
        sb.append("4개 일치 (5000원)-").append(ranks.count(Rank.THIRD)).append("개").append("\n");
        sb.append("5개 일치 (5000원)-").append(ranks.count(Rank.SECOND)).append("개").append("\n");
        sb.append("6개 일치 (5000원)-").append(ranks.count(Rank.FIRST)).append("개").append("\n");
        System.out.println(sb);
    }
}
