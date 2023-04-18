import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckSumTest {

    //TODO
    /*
     000000000
     130000000
     000000051
     immport
     create write
     add star
     all
          */

    @Test
    public void ZeroShouldBeACorrectAccount () {
        Assertions.assertEquals(false, CheckSum.accountVerifyer("0"));
    }

    @Test
    public void thirteenShouldBeACorrectAccount () {
        Assertions.assertEquals(false, CheckSum.accountVerifyer("13"));
    }

    @Test
    public void accountShouldHave11digits () {
        Assertions.assertEquals(false, CheckSum.accountVerifyer("0"));
    }

    @Test
    public void nineZeroShouldBeACorrectAccount () {
        Assertions.assertEquals(true, CheckSum.accountVerifyer("000000000"));
    }

    @Test
    public void thirteenThenSeven0ShouldBeACorrectAccount () {
        Assertions.assertEquals(true, CheckSum.accountVerifyer("130000000"));
    }

    @Test
    public void seven0FiftyOneShouldBeACorrectAccount () {
        Assertions.assertEquals(true, CheckSum.accountVerifyer("000000051"));
    }

    @Test
    public void receiving902542346ShouldBeACorrectAccount () {
        Assertions.assertEquals(true, CheckSum.accountVerifyer("902542346"));
    }

    @Test
    public void receiving505687420ShouldBeAFalseAccount () {
        Assertions.assertEquals(false, CheckSum.accountVerifyer("505687420"));
    }

    @Test
    public void importAccountToArraylist() {
        Assertions.assertEquals("902542346", CheckSum.importAccounts("src/main/resources/account.txt").get(0));
    }

    @Test
    public void createAndWriteInFile() {
        CheckSum.createAndWriteInFile(List.of("toto"));
        Assertions.assertEquals("toto", CheckSum.importAccounts("src/main/resources/result.txt").get(0));
    }

    @Test
    public void writeAStartOnFalseAccount() {
        Assertions.assertEquals("000000100*", CheckSum.importAccountAndAddStarForIncorrectNumber("src/main/resources/toto.txt").get(0));
    }

    @Test void whenReceivedATxtWithAccountNumberImportCheckAndWriteAFileWithStarForIncorrectNumber() {

        CheckSum.verifyAccounts("src/main/resources/account.txt");
        Assertions.assertEquals("505687420*", CheckSum.importAccounts("src/main/resources/result.txt").get(1));
    }
}
