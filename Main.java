import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        User user = null;
        Expense expense = null;
        while(option<=8)
        {
            switch (option)
            {
                case 1:
                    user = new User();
                    System.out.println("Enter user_name : ");
                    String user_name = sc.next();
                    System.out.println("Enter password : ");
                    String password = sc.next();
                    user.setUser_name(user_name);
                    user.setPassword(password);
                    user.sign_up();
                    for(String key : User.signed_up_users.keySet())
                    {
                        System.out.println("name : " + key + " "+"password " + User.signed_up_users.get(key).password);
                    }
                    break;
                case 2:
                    user = new User();
                    System.out.println("Enter user_name to login : ");
                    String usr_name = sc.next();
                    System.out.println("Enter password to login : ");
                    String pswrd = sc.next();
                    user.login(usr_name,pswrd);
                    break;
                case 3:
                    user.logout();
                    break;
                case 4:
                    Group group = new Group("anukarthi");
                    group.create_group();
                    group.groups_of_user(user);
                    break;
                case 5:
                    expense = new Expense();
                    expense.setExpense_amount(300);
                    expense.setGroup_name("anukarthi");
                    expense.create_expense();
                    break;
                case 6:
                    System.out.println("Expenses");
                    for(String key : user.user_groups.keySet())
                    {
                        System.out.println("Group Name : " + key);
                        System.out.println("Shared Between : ");
                        for(User member : user.user_groups.get(key).group_members)
                        {
                            System.out.print(member.user_name+" ");
                        }
                        System.out.println("Expenses To Be Shared : "+ expense.getExpense_amount());
                    }
                    break;
                case 7:
                    System.out.println("Amount to be paid : ");
                    expense.paid_amount_list();
                    break;
                case 8:
                    System.out.println("Amount to be received : ");
                    expense.received_amount_list();
                    break;
                default:
                    System.out.println("No option");
            }
            option = sc.nextInt();
        }

    }
}
