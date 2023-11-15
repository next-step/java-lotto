package step1.view;

public class OperatorOutputView {

    private final int result;

    public OperatorOutputView(int result) {
        this.result = result;
    }

    public void result() {
        System.out.println(result);
    }
}
