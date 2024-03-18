public class ResultView {

    private ResultView() {
    }

    public static void print(Lottos lottos) {
        System.out.printf("%d개를 구입하였습니다.\n", lottos.getLottoCount());
        System.out.println(lottos);
    }
}
