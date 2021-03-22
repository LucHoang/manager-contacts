package com.contactsmanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class FileManager {
    static Scanner input = new Scanner(System.in);

    public static void readFile() {
        try {
            File file = new File(".\\data\\contacts.csv");

            if (!file.exists()) {
                System.out.println("File không tồn tại!");
                return;
            }

            System.out.println("Import thông tin từ file sẽ xóa và cập nhật lại toàn bộ nội dung sản phẩm");
            System.out.println("Nhấn Enter để tiếp tục");
            String choose = input.nextLine();

            if (choose.isEmpty()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

                String line = bufferedReader.readLine();

                ContactsManager.listContacts.clear();

                while ((line = bufferedReader.readLine()) != null) {
                    String[] words = line.split(",");
                    Contacts contacts = new Contacts();

                    contacts.setNumberPhone(words[0]);
                    contacts.setGroup(words[1]);
                    contacts.setName(words[2]);
                    contacts.setGender(words[3]);
                    contacts.setAddress(words[4]);
                    contacts.setBirthDay(words[5]);
                    contacts.setEmail(words[6]);

                    ContactsManager.listContacts.add(contacts);
                }
                bufferedReader.close();
                System.out.println("Import thông tin từ file thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        if (ContactsManager.listContacts.isEmpty()) {
            System.out.println("Danh sách trống!!!");
            return;
        }
        System.out.println("Ghi vào file sẽ cập nhật lại toàn bộ nội dung file");
        System.out.println("Nhấn Enter để tiếp tục");
        String choose = input.nextLine();
        if (choose.isEmpty()) {
            try {
                File file = new File(".\\data\\contacts.csv");
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fileWriter = new FileWriter(file);

                fileWriter.write("Số điện thoại,Nhóm,Họ tên,Giới tính,Địa chỉ,Ngày sinh,Email\n");
                for (Contacts contacts : ContactsManager.listContacts) {
                    fileWriter.write(contacts.formatString() + "\n");
                }

                fileWriter.close();
                System.out.println("Ghi file thành công");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
