import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Java main class used as runner.
 *
 */
public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    String path = args[0];
    DataProcessor processor = new DataProcessor();

    List<String> sortedList = processor.sortWords(getFileInputStream(path));
    System.out.println("Ordered List: " + sortedList);

    Map<String, Long> sortedDecreasedMap = processor.countAndSortDecreasedWords(getFileInputStream(path));
    System.out.println("Sorted map in decreasing order:");
    for(Map.Entry entry : sortedDecreasedMap.entrySet()) {
      System.out.println(entry);
    }
  }

  private static InputStream getFileInputStream(String filePath) throws FileNotFoundException {
      return new FileInputStream(filePath);
  }

}
