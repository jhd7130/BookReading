import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.example.chapter01.code.Invoice;
import org.example.chapter01.code.Play;
import org.example.chapter01.code.Plays;
import org.example.chapter01.code.Statment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Chapter01Test {

  private final ObjectMapper mapper = new ObjectMapper();
  @Test
  @DisplayName("설명 입력하기")
  void writingMethodName() throws Exception {
    // Arrange
    Map<String, Play> playsMap = mapper.readValue(
        new File("/Users/jeongheedoo/Desktop/study/reading-journal/refactoring2nd/src/test/java/plays.json"),
        mapper.getTypeFactory().constructMapType(Map.class, String.class, Play.class)
    );
    Plays plays = new Plays(playsMap);
    Invoice invoice = mapper.readValue(new File("/Users/jeongheedoo/Desktop/study/reading-journal/refactoring2nd/src/test/java/invoice.json"), Invoice.class);

    // Act
    Statment statment = new Statment();
    statment.statement(invoice, plays);
    // Assert
  }

}
