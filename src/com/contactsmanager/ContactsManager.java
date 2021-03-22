package com.contactsmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {
    static List<Contacts> listContacts = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public ContactsManager() {

    }

    public void displayContacts() {
        boolean isLoop = true;
        int start = 0;
        int end = 4;
        System.out.println("Chọn 1 để thêm mới");

        int count = 0;

        while (isLoop) {
            for (int i=start; i<=end; i++) {
                if (i> listContacts.size()-1) {
                    break;
                }
                System.out.println("STT "+(i+1)+": "+ listContacts.get(i));
                count++;
            }
            System.out.print("Đã hiển thị "+count+"/"+ listContacts.size());

            if (end>= listContacts.size()-1) break;
            System.out.println(" | Enter để xem tiếp");
            start+=5;
            end+=5;

            String check = input.nextLine();
            if (check.equalsIgnoreCase("1")) {
                addContacts();
                isLoop = false;
            }
        }
    }

    public void addContacts() {
        Contacts contacts = new Contacts();
        inputContact(contacts, true);

        listContacts.add(contacts);
        System.out.println("Đã thêm thành công");
    }

    public void inputContact(Contacts contacts, boolean check) {
        if (check) {
            System.out.print("Nhập số điện thoại: ");
            while (true) {
                String numberPhone = input.nextLine();
                boolean isvalid = contacts.validate(numberPhone);

                if (numberPhone.isEmpty() || !isvalid) {
                    System.err.print("Số điện thoại có 10 số, phải bắt đầu bằng số 0! Hãy nhập lại: ");
                } else {
                    boolean isExist = true;
                    for (Contacts element : listContacts) {
                        if (element.getNumberPhone().equals(numberPhone)) {
                            System.err.print("Số điện thoại đã tồn tại! Hãy nhập lại: ");
                            isExist = false;
                            break;
                        }
                    }
                    if (isExist) {
                        contacts.setNumberPhone(numberPhone);
                        break;
                    }
                }
            }
        }

        System.out.print("Nhập nhóm của danh bạ: ");
        while (true) {
            String group = input.nextLine();
            if (!group.isEmpty()) {
                contacts.setGroup(group);
                break;
            }
            System.err.print("Nhập nhóm của danh bạ (không được để trống): ");
        }

        System.out.print("Nhập họ tên: ");
        while (true) {
            String name = input.nextLine();
            if (!name.isEmpty()) {
                contacts.setName(name);
                break;
            }
            System.err.print("Nhập họ tên (không được để trống): ");
        }

        System.out.print("Nhập giới tính: ");
        while (true) {
            String gender = input.nextLine();
            if (!gender.isEmpty()) {
                contacts.setGender(gender);
                break;
            }
            System.err.print("Nhập giới tính (không được để trống): ");
        }

        System.out.print("Nhập địa chỉ: ");
        while (true) {
            String address = input.nextLine();
            if (!address.isEmpty()) {
                contacts.setAddress(address);
                break;
            }
            System.err.print("Nhập địa chỉ (không được để trống): ");
        }

        System.out.print("Nhập ngày sinh: ");
        while (true) {
            String birthDay = input.nextLine();
            if (!birthDay.isEmpty()) {
                contacts.setBirthDay(birthDay);
                break;
            }
            System.err.print("Nhập ngày sinh (không được để trống): ");
        }

        System.out.print("Nhập email: ");
        while (true) {
            String email = input.nextLine();

            if (email != null && email.contains("@") && !email.contains(" ")) {
                contacts.setEmail(email);
                break;
            }
            System.err.print("Nhập lại email (email phải chứa @ và không có ký tự khoảng trắng): ");
        }
    }

    public void editContact() {
        while (true) {
            System.out.print("Nhập số điện thoại của danh bạ cần sửa: ");
            String numberFind = input.nextLine();
            boolean isFind = true;
            boolean isEdit = true;

            if (numberFind.isEmpty()) {
                break;
            } else {
                for (Contacts contacts : listContacts) {
                    if (contacts.getNumberPhone().equals(numberFind)) {
                        inputContact(contacts,false);

                        System.out.println("Đã cập nhật thành công");
                        isFind = false;
                        isEdit = false;
                        break;
                    }
                }
                if (isFind) {
                    System.out.println("Không tìm được danh bạ với số điện thoại trên.");
                }
            }
            if (!isEdit) break;
        }
    }

    public void deleteContact() {
        while (true) {
            System.out.print("Nhập số điện thoại của danh bạ muốn xóa: ");
            //String temp = input.nextLine();
            String numberFind = input.nextLine();
            boolean isFind = true;
            boolean isEdit = true;

            if (numberFind.isEmpty()) {
                break;
            } else {
                for (Contacts contacts : listContacts) {
                    if (contacts.getNumberPhone().equals(numberFind)) {
                        System.out.print("Bạn chắc chắn muốn xóa sản phẩm -> Y?");
                        String chosse = input.nextLine();
                        if (chosse.equalsIgnoreCase("Y")) {
                            listContacts.remove(contacts);

                            System.out.println("Đã xóa thành công");
                            isFind = false;
                            isEdit = false;
                            break;
                        }
                        isFind = false;
                        isEdit = false;
                    }
                }
                if (isFind) {
                    System.out.println("Không tìm được danh bạ với số điện thoại trên.");
                }
            }
            if (!isEdit) break;
        }
    }

    public void findByName() {
        System.out.print("Nhập họ tên cần tìm: ");
        String name = input.nextLine();
        boolean isFind = true;

        for (Contacts contacts: listContacts) {
            if (contacts.getName().equalsIgnoreCase(name)) {
                System.out.println(contacts);
                isFind = false;
            }
        }
        if (isFind) {
            System.out.println("Không tìm thấy!");
        }
    }

    public void findByNumberPhone() {
        System.out.print("Nhập số điện thoại cần tìm: ");
        String numberPhone = input.nextLine();
        boolean isFind = true;

        for (Contacts contacts: listContacts) {
            if (contacts.getNumberPhone().equals(numberPhone)) {
                System.out.println(contacts);
                isFind = false;
                break;
            }
        }
        if (isFind) {
            System.out.println("Không tìm thấy!");
        }
    }
}
