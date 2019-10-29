import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        while(true){
            mene();
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select){
                case 1:
                    add(contact,scanner);
                    break;
                case 2:
                    search(contact,scanner);
                    break;
                case 3:
                   remove(contact,scanner);
                    break;
                case 4:
                    update(contact,scanner);
                    break;
                    default:
                        System.out.println("Wrong");
            }
        }
    }

    private static void remove(Contact contact, Scanner scanner) {
        System.out.println("Please input the name:");
        String name = scanner.nextLine();
        try {
            contact.remove(contact,name);
        }catch (NameNotExistException e){
            System.out.println("Name is not exists");
        }finally {
            System.out.println("***********8");
        }
    }

    private static void update(Contact contact, Scanner scanner) {
        System.out.println("Please input the name:");
        String name = scanner.nextLine();
        try {
            contact.updata(contact,name);
            System.out.println("Please input new privatephone");
            String privatephone = scanner.nextLine();
            System.out.println("Please input new officephone");
            String officephone = scanner.nextLine();
        }catch (NameNotExistException e){
            System.out.println("Name is not exists");
        }finally {
            System.out.println("***********8");
        }
    }

    private static void search(Contact contact, Scanner scanner) {
        System.out.println("Please input name");
        String name = scanner.nextLine();
        User user = contact.get(name);
        if(user == null){
            System.out.println("empty");
        }else{
            System.out.println(user.privatephone);
            System.out.println(user.officeNumber);
        }
        try{
            contact.search(name);
            System.out.println("Success Searching");
        }catch (NameNotExistException e){
            System.out.println("Name is not exist");
        }
        finally {
            System.out.println("*************");
        }
    }


    private static void add(Contact contact,Scanner scanner) {
        System.out.println("Please input name:");
        String name = scanner.nextLine();
        System.out.println("Please input phonenumber:");
        String privatephone = scanner.nextLine();
        System.out.println("Please input officenumber:");
        String officeNumber = scanner.nextLine();
        try {
            contact.add(name, privatephone, officeNumber);
            System.out.println("Success add");
        } catch (NameExistException e) {
            System.out.println("The name has already exist");
        }finally {
            System.out.println("**************");
        }
    }
    private static void mene() {
        System.out.println("| 1. 添加");
        System.out.println("| 2. 查找");
        System.out.println("| 3. 删除");
        System.out.println("| 4. 更新");
        System.out.println("请选择正确的选项:");
    }
}
