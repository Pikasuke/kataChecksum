import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CheckSum {


    public static boolean accountVerifyer(String account) {
        if (account.length()!=9) {
            return false;
        }
        String[] accountArray = account.split("");
        int accumulateur = 0;
        int index = 9;
        for (int i = 0; i <accountArray.length; i++) {
            int number = Integer.parseInt(accountArray[i]);
            accumulateur += number*index;
            index--;
        }
        if (accumulateur % 11 == 0) {
            return true;
        }
        return false;
    }

    public static List<String> importAccounts(String path) {
        List<String> accountArray;
        try {
            accountArray = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return accountArray;
    }


    public static void createAndWriteInFile(List<String> stringList) {
        String fileName = "result.txt";
        try{
            Path file = Paths.get("src/main/resources/"+fileName);
            Files.write(file, stringList, StandardCharsets.UTF_8);
        }
        catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static List<String> importAccountAndAddStarForIncorrectNumber(String path) {
        List<String> words = CheckSum.importAccounts(path);
        List<String> results = new ArrayList<>();
        for (String accountNumber : words) {
            if (!accountVerifyer(accountNumber)) {
                results.add(accountNumber+"*");
            } else {
                results.add(accountNumber);
            }
        }
        return results;
    }


    public static void verifyAccounts(String path) {
        List<String> accounts = CheckSum.importAccountAndAddStarForIncorrectNumber(path);
        System.out.println(accounts);
        CheckSum.createAndWriteInFile(accounts);
    }
}
