package textcalculator.ui;

public class ConsoleResultView implements ResultView {

    public void showResult(int result){
        System.out.format("계산기 결과값은 : %d", result);
    }
}
