
import com.library.model.Book;
import com.library.service.LibraryService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LibraryTest {
    @Test
    void testCheckoutCheckin() {
        LibraryService s = new LibraryService();
        s.addBook(new Book("T1","Book","A"));
        assertTrue(s.checkout("T1"));
        assertFalse(s.checkout("T1"));
        assertTrue(s.checkin("T1"));
    }
}
