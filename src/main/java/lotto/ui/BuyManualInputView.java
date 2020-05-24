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

    protected BuyManualInputView(int count, List<String> inputValues) {
        this.manualLottoCount = count;
        this.inputValues = inputValues;
    }

    protected BuyManualInputView(int manualLottoCount) {
        this(manualLottoCount, new ArrayList<>());
    }

    public static BuyManualInputView getManualLottoCount(Scanner scanner) {
        System.out.println(System.lineSeparator() + "수동으로 구매할 로또 수를 입력해 주세요.");
        return new BuyManualInputView(scanner.nextInt(), new ArrayList<>());
    }

    public void getInputValues(Scanner scanner) {
        System.out.println(System.lineSeparator() + "수동으로 구매할 번호를 입력해 주세요.");
        IntStream.range(0, manualLottoCount)
                .forEach(num -> inputValues.add(scanner.nextLine()));
    }

    public LottoTickets convertToManualLottoTickets() {
        convertValidation();
        return LottoTickets.create(
                inputValues.stream()
                        .map(LottoGenerator::createByManual)
                        .collect(Collectors.toList())
        );
    }

    private void convertValidation() {
        if (manualLottoCount != inputValues.size()) {
            throw new IllegalArgumentException();
        }
    }
}
