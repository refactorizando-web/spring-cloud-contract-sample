import com.refactorizando.samples.springcloudcontract.producer.ProducerApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ProducerApplication.class)
public class ContextTest {

    @Test
    public void whenContextIsLoading_thenNoExceptions() {
    }
}