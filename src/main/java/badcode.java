import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class badcode {

    public static String password = "admin123"; // Hardcoded password

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = 10;
        int y = 0;

        // Division by zero possibility
        try {
            System.out.println(x / y);
        } catch (Exception e) {
            // Empty catch block
        }

        String name = null;

        // Null pointer issue
        System.out.println(name.length());

        // Duplicate code
        for(int i=0;i<5;i++) {
            System.out.println("Hello");
        }

        for(int i=0;i<5;i++) {
            System.out.println("Hello");
        }

        // Unused variable
        int unused = 100;

        // Bad nested conditions
        int a = 5;
        int b = 10;
        int c = 20;

        if(a > 0) {
            if(b > 0) {
                if(c > 0) {
                    if(a + b + c > 10) {
                        System.out.println("Too many nested ifs");
                    }
                }
            }
        }

        // SQL Injection vulnerability
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/test",
                    "root",
                    "root");

            Statement stmt = con.createStatement();

            String userInput = sc.nextLine();

            String query =
                    "SELECT * FROM users WHERE name='"
                            + userInput + "'";

            stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Infinite loop risk
        while(true) {
            break;
        }

        // Dead code
        if(false) {
            System.out.println("Never executes");
        }

        // Magic numbers
        int result = 45 * 78 / 12;
        System.out.println(result);

        sc.close();
    }
}