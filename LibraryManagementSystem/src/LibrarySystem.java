import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;
public class LibrarySystem {
    LibrarySystem() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> bookArrayList = new ArrayList<>();
        ArrayList<User> userArrayList = new ArrayList<>();
        ArrayList<BorrowRecord> borrowRecords = new ArrayList<>();
        boolean value = true;
        print();
        while (value) {
            System.out.println("Enter your choice-");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    User newUser = new User();

                    boolean isDuplicate = true;
                    int ip_userid = 0;
                    while (isDuplicate) {
                        System.out.println("Enter user id:");
                        ip_userid = sc.nextInt();
                        isDuplicate = false;

                        // Check if ID already exists
                        for (User u : userArrayList) {
                            if (u.getUserid() == ip_userid) {
                                System.out.println("User ID already exists! Please enter a different ID.");
                                isDuplicate = true;
                                break;
                            }
                        }
                    }
                    System.out.println("Enter user name");
                    String ip_username = sc.next();
                    newUser.setUsername(ip_username);
                    newUser.setUserid(ip_userid);
                    userArrayList.add(newUser);
                    break;
                case 2:
                    System.out.println("Enter user id-");
                    int blockval = 0;
                    int remove_id = sc.nextInt();
                    for (User u : userArrayList) {
                        if (u.getUserid() == remove_id) {
                            blockval = 1;
                            userArrayList.remove(u);
                            break;
                        }
                    }
                    if (blockval == 0) {
                        System.out.println("No user exists with such ID = " + remove_id);
                    }
                    break;
                case 3:
                    Book newBook = new Book();
                    boolean isDuplicate1 = true;
                    int ip_bookid = 0;
                    while (isDuplicate1) {
                        System.out.println("Enter book id:");
                        ip_bookid = sc.nextInt();
                        isDuplicate1 = false;

                        // Check if ID already exists
                        for (Book b : bookArrayList) {
                            if (b.getBookid() == ip_bookid) {
                                System.out.println("Book ID already exists! Please enter a different ID.");
                                isDuplicate1 = true;
                                break;
                            }
                        }
                    }
                    System.out.println("Enter book name");
                    String ip_bookname = sc.next();
                    newBook.setBookid(ip_bookid);
                    newBook.setBookname(ip_bookname);
                    bookArrayList.add(newBook);

                    break;
                case 4:
                    System.out.println("Enter book id-");
                    int blockval2 = 0;
                    int remove_id2 = sc.nextInt();
                    for (Book b : bookArrayList) {
                        if (b.getBookid() == remove_id2) {
                            blockval2 = 1;
                            userArrayList.remove(b);
                            System.out.println("Book details removed successfully");
                            break;
                        }
                    }
                    if (blockval2 == 0) {
                        System.out.println("No user exists with such ID = " + remove_id2);
                    }
                    break;
                case 5:
                    System.out.println("Enter user id to which the book has to borrowed");
                    int user_id = sc.nextInt();
                    System.out.println("Enter book id which has to borrowed");
                    int book_id = sc.nextInt();
                    User user = findUser(user_id,userArrayList);
                    Book book = findBook(book_id,bookArrayList);
                    sc.nextLine();
                    System.out.println("Enter the borrow date (yyyy-mm-dd) format only-");
                    LocalDate dateTaken = null;
                    while (true) {
                        String date = sc.nextLine();
                        try {
                            dateTaken = LocalDate.parse(date);
                            System.out.println("You entered the date = " + dateTaken);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Date Format");
                        }
                    }
                    if(book != null && user != null){
                        BorrowRecord b1 = new BorrowRecord(user,book,dateTaken);
                        borrowRecords.add(b1);
                        System.out.println("Record Added successfully");
                    }
                    else{
                        System.out.println("User or Book not found");
                    }
                    break;
                case 6:
                    System.out.println("Enter user id");
                    user_id = sc.nextInt();
                    System.out.println("Enter book id");
                    book_id = sc.nextInt();
                    user = findUser(user_id,userArrayList);
                    book = findBook(book_id,bookArrayList);
                    sc.nextLine();
                    System.out.println("Enter the return date (yyyy-mm-dd) format only-");
                    LocalDate dateReturned= null;
                    while (true) {
                        String date = sc.nextLine();
                        try {
                            dateReturned = LocalDate.parse(date);
                            System.out.println("You entered the date = " + dateReturned);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid Date Format");
                        }
                    }
                    for(BorrowRecord record : borrowRecords){
                        if(record.getUser().getUserid() == user_id && record.getBook().getBookid() == book_id && record.getDateReturned() == null){
                            record.returnBook(dateReturned);
                            System.out.println("Book returned.");
                            break;
                        }
                    }
                    break;
                case 7:

                    System.out.println("All records..");

                    for(BorrowRecord b2 : borrowRecords){
                        LocalDate date1 = b2.getDateTaken();
                        System.out.println(date1);
                        String datetaken = null;
                        if(date1 != null){
                            datetaken =date1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        }
                        LocalDate date2 = b2.getDateReturned();
                        String datereturn = null;
                        if(date2 != null){
                            datereturn = date2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        }

                        System.out.printf("User %s borrowed the book %s on %s and returned on %s \n ",b2.getUser().getUsername(),b2.getBook().getBookname(),datetaken,datereturn);
                    }
                    break;
                case 8:
                    value = false;
                    break;
                default:
                    System.out.println("Wrong choice please re-enter");

            }


        }
    }
    void print(){
        System.out.println("Welcome to Library Management System");
        System.out.println("1.Add User");
        System.out.println("2,Remove User");
        System.out.println("3.Add Book");
        System.out.println("4.Remove Book");
        System.out.println("5.Borrow Book");
        System.out.println("6.Return Book");
        System.out.println("7.Show all records");
        System.out.println("8.Exit");
    }
    User findUser(int user_id, ArrayList<User> userArrayList){
            for(User u : userArrayList){
                if(u.getUserid() == user_id){
                    return u;
                }
            }
            return null;
    }
    Book findBook(int book_id,ArrayList<Book> bookArrayList){
        for(Book b : bookArrayList){
            if(b.getBookid() == book_id){
                return b;
            }
        }
        return null;
    }
}
