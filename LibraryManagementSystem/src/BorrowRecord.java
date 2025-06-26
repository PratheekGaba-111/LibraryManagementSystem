import java.time.LocalDate;
class BorrowRecord {
    private User user;
    private Book book;
    private LocalDate dateTaken;
    private LocalDate dateReturned;
    BorrowRecord(User user, Book book, LocalDate dateTaken){
        this.user = user;
        this.book = book;
        this.dateTaken = dateTaken;
        this.dateReturned = null;
    }
    void returnBook(LocalDate dateReturned){
        this.dateReturned = dateReturned;
    }
    User getUser(){
        return this.user;
    }
    Book getBook(){
        return this.book;
    }
    LocalDate getDateTaken(){
        return this.dateTaken;
    }
    LocalDate getDateReturned(){
        return this.dateReturned;
    }
}
