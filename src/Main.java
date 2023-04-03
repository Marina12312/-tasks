import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();
        text.lines().map(line -> line.toLowerCase().replace(",", "")
                        .replace(".", "")
                        .replace(":", "")
                        .replace("(", "")
                        .replace(")", "")
                        .toLowerCase()
                        .split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Comparator.comparing((Function<Map.Entry<String, Long>, Long>) Map.Entry::getValue)
                        .reversed())
                .limit(10)
                .forEach(System.out::println);
    }
}
