package com.contactsmanager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContactsManager contactsManager = new ContactsManager();
        String choose;

//        ContactsManager.listContacts.add(new Contacts("1", "1", "1", "1", "1", "1", "1"));
//        ContactsManager.listContacts.add(new Contacts("2", "1", "1", "1", "1", "1", "1"));
//        ContactsManager.listContacts.add(new Contacts("3", "1", "1", "1", "1", "1", "1"));
//        ContactsManager.listContacts.add(new Contacts("4", "1", "1", "1", "1", "1", "1"));
//        ContactsManager.listContacts.add(new Contacts("5", "1", "1", "1", "1", "1", "1"));
//        ContactsManager.listContacts.add(new Contacts("6", "1", "1", "1", "1", "1", "1"));
//        ContactsManager.listContacts.add(new Contacts("7", "1", "1", "1", "1", "1", "1"));

        while (true) {
            try {
                showMenu();
                choose = input.nextLine();

                switch (choose) {
                    case "1":
                        if (ContactsManager.listContacts.isEmpty()) {
                            System.out.println("Danh sách trống!!!");
                            break;
                        }
                        contactsManager.displayContacts();
                        break;
                    case "2":
                        contactsManager.addContacts();
                        break;
                    case "3":
                        if (ContactsManager.listContacts.isEmpty()) {
                            System.out.println("Danh sách trống!!!");
                            break;
                        }
                        contactsManager.editContact();
                        break;
                    case "4":
                        if (ContactsManager.listContacts.isEmpty()) {
                            System.out.println("Danh sách trống!!!");
                            break;
                        }
                        contactsManager.deleteContact();
                        break;
                    case "5":
                        if (ContactsManager.listContacts.isEmpty()) {
                            System.out.println("Danh sách trống!!!");
                            break;
                        }
                        System.out.println("1. Tìm kiếm theo số điện thoại");
                        System.out.println("2. Tìm kiếm theo họ tên");
                        System.out.println("0. Exit");
                        System.out.print("Choose: ");
                        String select = input.nextLine();
                        switch (select) {
                            case "1":
                                contactsManager.findByNumberPhone();
                                break;
                            case "2":
                                contactsManager.findByName();
                                break;
                            case "0":
                                break;
                            default:
                                System.out.println("Lựa chọn ngoài phạm vi!!!");
                        }
                        break;
                    case "6":
                        FileManager.readFile();
                        break;
                    case "7":
                        FileManager.writeFile();
                        break;
                    case "8":
                        System.out.println("Goodbye!!!");
                        System.exit(1);
                    default:
                        System.err.println("Lựa chọn ngoài phạm vi!!!");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.err.println("Nhập sai định dạng!!!");
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
