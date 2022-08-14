package domain;

import java.util.List;
import java.util.Objects;

public class ComplexSelectRule implements SelectRule {
    private final List<SelectRule> selectRules;

    private ComplexSelectRule(List<SelectRule> selectRules) {
        this.selectRules = selectRules;
    }

    public static ComplexSelectRule create(ManualSelectRule manualSelectRule, RandomSelectRule randomSelectRule) {
        return new ComplexSelectRule(List.of(manualSelectRule, randomSelectRule));
    }

    @Override
    public boolean isSelectable() {
        return selectRules.stream().anyMatch(SelectRule::isSelectable);
    }

    @Override
    public LottoNumbers select() {
        SelectRule selectableSelectRule = selectRules.stream()
                .filter(SelectRule::isSelectable)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("로또를 발행할 수 있는 SelectRule이 없습니다."));

        return selectableSelectRule.select();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexSelectRule that = (ComplexSelectRule) o;
        return selectRules.equals(that.selectRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectRules);
    }
}
