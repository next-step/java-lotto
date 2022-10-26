import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<String> inputList = inputView.getUserInputToStringList();
        Calcurator calcurator = new Calcurator(inputList);
        int result = calcurator.calculate().getNumber();
    }
}
