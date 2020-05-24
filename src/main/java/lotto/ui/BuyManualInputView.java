package lotto.ui;

import lotto.domain.lotto.LottoGenerator;
import lotto.domain.lotto.LottoTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuyManualInputView {
    private int manualLottoCount;
    private List<String> inputValues;

    public BuyManualInputView(int i) {
        this(i, new ArrayList<>());
    }

    public void getInputValues(Scanner scanner) {
        System.out.println("수동으로 만들 로또 번호를 입력해주세요");
        IntStream.range(0, manualLottoCount)
                .forEach(num -> inputValues.add(scanner.nextLine()));
    }

    protected BuyManualInputView(int count, List<String> inputValues) {
        this.manualLottoCount = count;
        this.inputValues = inputValues;
    }

    public LottoTickets convertToManualLottoTickets() {
        convertValidation();
        return LottoTickets.create(
                inputValues.stream()
                        .map(LottoGenerator::createFromString)
                        .collect(Collectors.toList())
        );
    }

    private void convertValidation() {
        if (manualLottoCount != inputValues.size()) {
            throw new IllegalArgumentException();
        }
    }
}
