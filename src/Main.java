import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        SecurePassword s = new SecurePassword(password);
        System.out.println(s.status());



    }
}
