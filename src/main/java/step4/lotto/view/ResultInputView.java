package step4.lotto.view;

public class ResultInputView {
    public void displayResultTitle() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }

    public void displayLotto(int lottoCount, int manualCount, String displaylottos) {
        System.out.println(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", lottoCount - manualCount, manualCount));
        System.out.println(displaylottos);
    }

    public void display(String text) {
        System.out.println(text);
    }
}
