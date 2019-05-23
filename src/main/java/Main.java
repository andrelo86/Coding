import java.io.File;
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

  private static final String PATH = "src" +
    File.separator + "main" +
    File.separator + "resources" +
    File.separator + "text";

  public static void main(String[] args) throws FileNotFoundException {

    DataProcessor processor = new DataProcessor();

    List<String> sortedList = processor.sortWords(getFileInputStream(PATH));
    System.out.println("Ordered List: " + sortedList);

    Map<String, Long> sortedDecreasedMap = processor.countAndSortDecreasedWords(getFileInputStream(PATH));
    System.out.println("Sorted map in decreasing order:");
    for(Map.Entry entry : sortedDecreasedMap.entrySet()) {
      System.out.println(entry);
    }
  }

  public static InputStream getFileInputStream(String filePath) throws FileNotFoundException {
      return new FileInputStream(filePath);
  }

}
