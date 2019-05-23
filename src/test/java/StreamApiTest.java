import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamApiTest {

  private static final String TEST_DATA_FILEPATH = "src" +
      File.separator + "test" +
      File.separator + "java" +
      File.separator + "resources" +
      File.separator + "testdata";

  private static final int WORDS_QUANTITY = 13;


  private DataProcessor dataProcessor = new DataProcessor();

  @Test
  private void checkCorrectNumberOfWords() throws FileNotFoundException {
    int numberOfWords = dataProcessor.sortWords(Main.getFileInputStream(TEST_DATA_FILEPATH)).size();

    Assert.assertEquals(numberOfWords, WORDS_QUANTITY, "Method is not counting words correctly.");
  }

  @Test
  private void checkNotEmptyData() throws FileNotFoundException {
    List<String> wordsList = dataProcessor.sortWords(Main.getFileInputStream(TEST_DATA_FILEPATH));

    Assert.assertTrue(!wordsList.isEmpty(),"Something went wrong processing data, Collection is EMPTY.");
  }

  @Test
  private void checkEmptyDataStreamForSortedList() {
    InputStream inputStream = getEmptyInputStream();
    List<String> wordsList = dataProcessor.sortWords(inputStream);

    Assert.assertTrue(wordsList.isEmpty(), "Collection should be empty due to empty file.");
  }

  @Test
  private void checkEmptyDataStreamForSortedDecreasedMap() {
    InputStream inputStream = getEmptyInputStream();
    Map<String, Long> wordsList = dataProcessor.countAndSortDecreasedWords(inputStream);

    Assert.assertTrue(wordsList.isEmpty(), "Collection should be empty due to empty file.");
  }

  private InputStream getEmptyInputStream() {
    String initString = "";
    return new ByteArrayInputStream(initString.getBytes());
  }

}
