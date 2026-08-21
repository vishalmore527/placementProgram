import java.util.Scanner;
public class loopingConstruct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double principal=scanner.nextDouble();
        double rate=scanner.nextDouble();
        int years=scanner.nextInt();
        //print yerar by year breakdown using a loop
        //print final maturity amount and total intrest
        //principal amount P, intrest R%,for T years
        //print year ,opening balance, interest earned, closing balance
        
        for(int i=1;i<=years;i++){
            double interestEarned = principal * rate / 100;
            double closingBalance = principal + interestEarned;
            System.out.println("Year: " + i);
            System.out.println("Opening Balance: " + principal);
            System.out.println("Interest Earned: " + interestEarned);
            System.out.println("Closing Balance: " + closingBalance);
            principal = closingBalance; // Update principal for next year

        }
        scanner.close();
    }
}
