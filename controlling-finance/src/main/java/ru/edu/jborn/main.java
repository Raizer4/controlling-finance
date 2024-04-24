package ru.edu.jborn;

import org.w3c.dom.ls.LSOutput;
import ru.edu.jborn.dao.AccountDaoImp;
import ru.edu.jborn.dao.UserDaoImp;
import ru.edu.jborn.dao.domain.Account;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws SQLException {

        System.out.println("Привет, рады приветсвовать вас в нашем приложении, вы хотите:");

        UserDaoImp imp = UserDaoImp.getUserDaoImp();
        AccountDaoImp adi = new AccountDaoImp();
        Integer id = null;

        while (true) {
            System.out.println("1-авторизоваться");
            System.out.println("2-зарегистрироваться");
            int choice = new Scanner(System.in).nextInt();
            if (choice == 1) {

                System.out.println("Введите логин:");
                String name = new Scanner(System.in).nextLine();

                System.out.println("Введите пароль:");
                String password = new Scanner(System.in).nextLine();

                Integer idTemporal = imp.authorization(name, password);

                if (idTemporal != null) {
                    System.out.println("Вы успешно авторизовались");
                    id = idTemporal;
                    break;
                } else {
                    System.out.println("Такого пользователя нет");
                }

            }
            else if (choice == 2) {

                System.out.println("Введите имя");
                String name = new Scanner(System.in).nextLine();

                System.out.println("Введите пароль");
                String password = new Scanner(System.in).nextLine();

                System.out.println("Введите почту");
                String email = new Scanner(System.in).nextLine();

                imp.registration(name, password, email);

                System.out.println("Вы успешно зарегистриовались");

            }
        }


        System.out.println("1-Вывести список счетов");

        int h = new Scanner(System.in).nextInt();

        if (h == 1) {
           List<Account> list = adi.findById(id);
           for (Account account : list){
               System.out.println(account);
           }
        }





        System.out.println("Создать счет");
        System.out.println("Создать категорю транзакций");
        System.out.println("Показать категорю транзакций");






    }

}
