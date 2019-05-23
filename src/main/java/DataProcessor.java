import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.io.BufferedReader;
import java.io.InputStream;
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
 * Class designed to customize data processor.
 */
public class DataProcessor {

  private static final String REGEX = "\\W+";

  public DataProcessor() {}

  /**
   * This method is used to get and sort words of a text.
   *
   * @param fileInputStream : Object SFileInputStream()
   */
  public List<String> sortWords(InputStream fileInputStream) {
      List<String> sortedList = new BufferedReader((new InputStreamReader(fileInputStream)))
          .lines()
          .map(it -> it.split(REGEX))
          .flatMap(Stream::of)
          .filter(s -> !s.isEmpty())
          .sorted().collect(
              Collectors.toList());
      return sortedList;
  }

  /**
   * This method is used to get and group words of a text
   * counting the appearances and sorting the tuples <String, Long> by value
   * in decreasing mode.
   *
   * @param fileInputStream : Object FileInputStream()
   */
  public Map<String, Long> countAndSortDecreasedWords(InputStream fileInputStream) {
      Map<String, Long> mappingCountedWords = new BufferedReader((new InputStreamReader(fileInputStream)))
          .lines()
          .map(it -> it.split(REGEX))
          .flatMap(Stream::of)
          .filter(s -> !s.isEmpty())
          .collect(groupingBy(Function.identity(), counting()));

      return getCollectInDecreasedOrder(mappingCountedWords);
  }

  private LinkedHashMap<String, Long> getCollectInDecreasedOrder(
      Map<String, Long> mappingCountedWords) {
    return mappingCountedWords
        .entrySet()
        .stream()
        .sorted(Collections.reverseOrder(Entry.comparingByValue()))
        .collect(
            Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e2,
                LinkedHashMap::new));
  }

}
