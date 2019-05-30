import java.io.InputStream;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamApiTest {

  private static final int WORDS_QUANTITY = 103;


  private DataProcessor dataProcessor = new DataProcessor();

  @Test
  private void checkCorrectNumberOfWords() {
    int numberOfWords = dataProcessor.sortWords(Utils.getDataInputStream()).size();

    Assert.assertEquals(numberOfWords, WORDS_QUANTITY, "Method is not counting words correctly.");
  }

  @Test
  private void checkNotEmptyData() {
    List<String> wordsList = dataProcessor.sortWords(Utils.getDataInputStream());

    Assert.assertTrue(!wordsList.isEmpty(),"Something went wrong processing data, Collection is EMPTY.");
  }

  @Test
  private void checkEmptyDataStreamForSortedList() {
    InputStream inputStream = Utils.getEmptyInputStream();
    List<String> wordsList = dataProcessor.sortWords(inputStream);

    Assert.assertTrue(wordsList.isEmpty(), "Collection should be empty due to empty file.");
  }

  @Test
  private void checkEmptyDataStreamForSortedDecreasedMap() {
    InputStream inputStream = Utils.getEmptyInputStream();
    Map<String, Long> wordsList = dataProcessor.countAndSortDecreasedWords(inputStream);

    Assert.assertTrue(wordsList.isEmpty(), "Collection should be empty due to empty file.");
  }

  @Test
  private void checkApplicationAllowsApostropheWords() {
    InputStream inputStream = Utils.getDataInputStream();
    List<String> wordsList = dataProcessor.sortWords(inputStream);

    Assert.assertTrue(wordsList.contains("O'Neill"), "Collection should have O'Neill.");
  }

}
