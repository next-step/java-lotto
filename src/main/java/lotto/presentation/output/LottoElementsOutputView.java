package lotto.presentation.output;

import java.util.List;

public class LottoElementsOutputView {
    public void output(List<String> elements){
        System.out.println("[" + String.join(", ", elements) + "]");
    }
}
