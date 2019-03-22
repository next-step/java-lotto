package lottogame.inputgetter;

import lottogame.domain.LottoNumberPackage;
import lottogame.view.InputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ManualNumbersInputGetter implements InputGettable<List<LottoNumberPackage>, Long> {

    @Override
    public List<LottoNumberPackage> getReturnObject(Long... parameters) {
        return LongStream.rangeClosed(1, parameters[0])
                    .mapToObj(number -> new LottoNumberPackage(InputView.getInputLine()))
                    .collect(Collectors.toList());
    }

    @Override
    public void showInputMessage() {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    }
}