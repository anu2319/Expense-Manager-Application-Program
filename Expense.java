import java.util.ArrayList;
import java.util.Scanner;

public class Expense
{
    private String group_name;
    private int expense_amount;
    static ArrayList<User> contributors = new ArrayList<>();
    public User expense_creator ;

    public void setExpense_amount(int expense_amount)
    {
        this.expense_amount = expense_amount;
    }

    public void setGroup_name(String group_name)
    {
        this.group_name = group_name;
    }

    public int getExpense_amount()
    {
        return expense_amount;
    }


    int option;
    String spcfd_user;
    Scanner sc = new Scanner(System.in);
    String exp_crtr ;

    public void create_expense()
    {
        System.out.println("Enter the creator of expense : ");
        exp_crtr = sc.next();
        expense_creator = User.signed_up_users.get(exp_crtr);
        System.out.println(expense_creator.user_name);

        if(!Group.created_groups.containsKey(group_name))
        {
            System.out.println("Expenses can not be added as the group is not available");
        }
        else
        {

            System.out.println("Enter how it should be shared : ");
            option = sc.nextInt();
            System.out.println("1. Expense shared equally among group memebers\n2.Expense shared equally among specified members");
            switch (option)
            {
                case 1:
                    contributors.addAll(Group.created_groups.get(group_name));
                    System.out.println("Expense Added Successfully");
                    break;
                case 2:
                    System.out.println("Enter users to be shared : ");
                    spcfd_user = sc.next();
                    contributors.add(User.signed_up_users.get(spcfd_user));
                    System.out.println("Expense Added Successfully");
                    break;
                default:
                    System.out.println("Option is not available");
            }
        }
        Group.user_expense_list.add(this);
    }

    public void paid_amount_list()
    {
        int paid_amount = 0;
        int number_of_contributors = contributors.size();
        if(option==1)
        {
            paid_amount+= expense_amount / number_of_contributors;
        }
        else
        {

            if(expense_creator.user_name == spcfd_user)
            {
                paid_amount+= expense_amount;
            }
        }
        System.out.println(expense_creator.user_name+" " + paid_amount);
    }

    public void received_amount_list()
    {
        int received_amount = 0;
        int number_of_contributors = contributors.size();
        if(option == 1)
        {
            received_amount+= (number_of_contributors-1) * (expense_amount/number_of_contributors);
        }
        else
        {
            if(!expense_creator.user_name.equals(spcfd_user))
            {
                received_amount+= expense_amount;
            }
        }
        System.out.println(expense_creator.user_name+" "+received_amount);
    }

}

