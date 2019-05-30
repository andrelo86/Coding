import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Utils {

  public static InputStream getDataInputStream() {
    String lineOne = "London, O'Neill 10 April 2019: Filming has commenced on Belgravia, a Julian Fellowes-penned six-part limited series for ITV and EPIX from Carnival Films, the makers of Downton Abbey.\nBelgravia is a story of secrets and scandals amongst the upper echelon of London society in the 19th Century. When the Trenchards accept an invitation to the now legendary ball hosted by the Duchess of Richmond on the fateful eve of the Battle of Waterloo, it sets in motion a series of events that will have consequences for decades to come as secrets unravel behind the porticoed doors of London’s grandest neighborhood.";

    return new ByteArrayInputStream(lineOne.getBytes());
  }

  public static InputStream getEmptyInputStream() {
    return new ByteArrayInputStream("".getBytes());
  }

}
