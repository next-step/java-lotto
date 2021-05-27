package config;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<ArraySources> {

    private List<List<Integer>> arguments;

    public void accept(ArraySources source) {
        List<ArraySource> arrays = List.of(source.value());

        this.arguments = arrays.stream()
                .map(arraySource -> toArrayList(arraySource.value()))
                .collect(Collectors.toList());
    }

    private List<Integer> toArrayList(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toList());
    }

    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return this.arguments.stream()
                .map(Arguments::of);
    }
}
