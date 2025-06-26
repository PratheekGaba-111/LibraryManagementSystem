# 📚 Library Management System (Java Console App)

This is a simple **Library Management System** built in Java using **OOP principles**. It runs in the console and allows you to manage users, books, borrow/return transactions, and keeps track of all records using in-memory storage (ArrayLists).

---

## 🚀 Features

- ✅ Add or remove users
- ✅ Add or remove books
- ✅ Borrow a book (records the date)
- ✅ Return a book (records the return date)
- ✅ Prevents duplicate user IDs and book IDs
- ✅ Displays all borrowing records
- ✅ Date input and validation using `LocalDate`
- ✅ Structured using `User`, `Book`, `BorrowRecord`, and `LibrarySystem` classes

---

## 🛠 Technologies Used

- **Java** (Console-based)
- **Java Collections (ArrayList)**
- **Java 8+ Date API (`LocalDate`)**

---

## 📂 Project Structure
LibraryManagementSystem/
│
├── Book.java # Book class with id and name
├── User.java # User class with id and name
├── BorrowRecord.java # Tracks who borrowed what and when
├── LibrarySystem.java # Main logic and menu
├── Main.java # (Optional) Create object of LibrarySystem to run


---

## 💻 How to Run

1. **Compile all `.java` files**:
   ```bash
   javac *.java
2. Run the application:
     java Main

---
🖼 Sample Menu

Welcome to Library Management System
1. Add User
2. Remove User
3. Add Book
4. Remove Book
5. Borrow Book
6. Return Book
7. Show all records
8. Exit

---
🧠 Notes
Uses ArrayList for all records (no database)

Handles duplicate ID validation

Ensures valid date input (yyyy-mm-dd format)

Console-only interface (can be extended with GUI or DB)

---
📌 Future Improvements
Add file/database persistence

GUI using Java Swing or JavaFX

Fine/penalty calculation for late returns

Admin login system

---
👨‍💻 Author
Pratheek Gaba
Java Developer | Student
