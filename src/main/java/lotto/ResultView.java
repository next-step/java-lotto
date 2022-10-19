package lotto;

public class ResultView {

    public void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(System.out::println);
    }
}
