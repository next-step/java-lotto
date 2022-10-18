package step1.model.operator;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Operators implements Iterable<Operator> {
	private static final List<String> OPERATORS = List.of(new String[] {"+", "-", "*", "/"});
	private List<Operator> operators;

	public Operators() {
	}

	public Operators(List<Operator> operators) {
		this.operators = operators;
	}

	public Operators convertToOperators(List<String> strings) {
		return new Operators(strings.stream()
			.map(Operator::new)
			.collect(Collectors.toList()));
	}

	@Override
	public Iterator<Operator> iterator() {
		return operators.iterator();
	}

	@Override
	public void forEach(Consumer<? super Operator> action) {
		Iterable.super.forEach(action);
	}

	public int indexOf(Operator operator) {
		return this.operators.indexOf(operator);
	}
}
