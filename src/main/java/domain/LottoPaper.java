package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPaper {
    private List<NumberSet> elements;

    public LottoPaper(LottoMoney lottoMoney) {
        elements = IntStream.range(0, lottoMoney.getLottoCount())
            .mapToObj(i -> NumberSet.empty())
            .collect(Collectors.toList());
    }

    public void fillManual(NumberSet numberSet) {
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).equals(NumberSet.empty())) {
                elements.set(i, numberSet);
                break;
            }
        }
    }

    public void fillManuals(List<NumberSet> numberSets) {
        numberSets.forEach(this::fillManual);
    }

    public Integer getAutoCount() {
        return (int) elements.stream()
            .filter(NumberSet::isEmpty)
            .count();
    }

    public Integer getManualCount() {
        return (int) elements.stream()
            .filter(e -> !e.isEmpty())
            .count();
    }

    public List<NumberSet> getElements() {
        return elements;
    }
}
