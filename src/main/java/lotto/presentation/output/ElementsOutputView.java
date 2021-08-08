package lotto.presentation.output;

import java.util.List;

public class ElementsOutputView {
    public void output(List<String> elements){
        System.out.println("[" + String.join(", ", elements) + "]");
    }
}
