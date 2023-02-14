import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Group
{
    private String group_name;
    ArrayList<User> group_members = new ArrayList<>();
    static HashMap<String,ArrayList<User>> created_groups = new HashMap<>();
    static ArrayList<Expense> user_expense_list = new ArrayList<>();


    public Group(String group_name)
    {
        this.group_name = group_name;
    }

    public void create_group()
    {
        int no_of_members = 3;
        Scanner sc = new Scanner(System.in);
        while(no_of_members!=0)
        {
            System.out.println("Enter user : ");
            String name = sc.nextLine();
            if(User.signed_up_users.containsKey(name))
            {
                group_members.add(User.signed_up_users.get(name));
            }
            else
            {
                System.out.println("Group can not be created - No user with user name " + name);
                return;
            }
            no_of_members--;
        }
        created_groups.put(group_name,group_members);
        System.out.println("Group created successfully");
    }

    public void groups_of_user(User user)
    {
        user.user_groups.put(group_name,this);
        System.out.println("Groups added successfully");
    }
}
