import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java main class used to run required exercises.
 *
 */
public class Main {

  private static final String PATH = "src\\main\\resources\\text";
  private static final String REGEX = "\\W+";

  public static void main(String[] args) {
    try {
      FileInputStream fileInputStream = new FileInputStream(PATH);
      List<String> sortedList = new BufferedReader((new InputStreamReader(fileInputStream)))
          .lines()
          .map(it -> it.split(REGEX))
          .flatMap(Stream::of)
          .filter(s -> !s.equals(""))
          .sorted().collect(
              Collectors.toList());
      System.out.println("Ordered List: " + sortedList);
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }

    try {
      FileInputStream fileInputStream = new FileInputStream(PATH);
      Map<String, Long> sortedTupleCollection = new BufferedReader((new InputStreamReader(fileInputStream)))
          .lines()
          .map(it -> it.split(REGEX))
          .flatMap(Stream::of)
          .filter(s -> !s.isEmpty())
          .collect(groupingBy(Function.identity(), counting()))
          .entrySet()
          .stream()
          .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
          .collect(
              Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2,
                  LinkedHashMap::new));
      System.out.println("Sorted map in decreasing order:");
      for(Map.Entry entry : sortedTupleCollection.entrySet()) {
        System.out.println(entry);
      }
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

}
