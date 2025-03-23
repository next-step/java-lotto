package tutorial.view;

public class ResultView {
    private ResultView() {
        throw new IllegalStateException("인스턴스를 생성할 수 없는 클래스입니다.");
    }

    public static void printResult(int result) {
        System.out.println("\n계산 결과: " + result + "\n");
    }
}
