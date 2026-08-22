import java.util.Scanner;
public class library {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //read bookid, due date(no of day ) if return date is more than due date then fine is 5rs per day
        //can issue multiple books.
        //after each book ask process another book(y/n) 
        // if return before display thank you message
        //at end display: total books prossed, total fine collected, a list of overdue book id.
        int totalFineCollected = 0;
        String[] overdueBooks = new String[100]; // Assuming a maximum of 100 overdue books
        int overdueCount = 0;
        int totalBooksProcessed = 0;
        boolean continueProcessing = true;
        while(continueProcessing){
            System.out.println("Do you want to process another book? (y/n)");
            String choice = sc.next();
            if(choice.equalsIgnoreCase("n")){
                continueProcessing=false;
                break;
            }
            sc.nextLine(); // consume leftover newline so nextLine() works correctly
        System.out.println("Enter the bookID to process:");
        String bookID = sc.nextLine();
        System.out.println("Enter the due date (in days):");
        int dueDate = sc.nextInt();
        System.out.println("Enter the return date (in days):");
        int returnDate = sc.nextInt();
        sc.nextLine(); // consume leftover newline
        if(returnDate > dueDate){
            int fine=(returnDate-dueDate)*5;
            totalFineCollected += fine; 
            overdueBooks[overdueCount] = bookID;
            overdueCount++;
            totalBooksProcessed++;

        }
        else{

            System.out.println("Thank you for returning the book on time.");
            totalBooksProcessed++;
        }
        
        }
        System.out.println("Total books processed: " + totalBooksProcessed);
        System.out.println("Total fine collected: " + totalFineCollected);
        System.out.println("Overdue books:");
        for(int i = 0; i < overdueCount; i++){
            System.out.println(overdueBooks[i]);
        }
    }
}
