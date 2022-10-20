import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Calcurator calcurator = new Calcurator();

        List<String> inputList = inputView.getUserInputToStringList();
        calcurator.calculate(inputList);
    }
}
